package app.controller;

import app.entity.ClassMemberRegistration;
import app.entity.ResponseBean;
import app.entity.UserInfo;
import app.entity.UserLessonLearningRecord;
import app.service.ClassMemberRegistrationService;
import app.service.UserInfoService;
import app.service.UserLessonLearningRecordService;
import ch.qos.logback.core.util.StringCollectionUtil;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学员学籍表(ClassMemberRegistration)表控制层
 *
 * @author makejava
 * @since 2020-06-16 21:57:57
 */
@RestController
@RequestMapping("/classMemberRegistration")
public class ClassMemberRegistrationController {
    private static Logger logger = LoggerFactory.getLogger(ClassMemberRegistrationController.class);
    /**
     * 服务对象
     */
    @Resource
    private ClassMemberRegistrationService classMemberRegistrationService;

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private UserLessonLearningRecordService userLessonLearningRecordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ClassMemberRegistration selectOne(Integer id) {
        return this.classMemberRegistrationService.queryById(id);
    }



    @PostMapping("/openLesson")
    public ResponseBean openLesson(@RequestBody ClassMemberRegistration classMemberRegistration){
        List<ClassMemberRegistration> classMemberRegistrations = new ArrayList<>();
        try{
            classMemberRegistrations = classMemberRegistrationService.insertByType(classMemberRegistration);
        }catch (NumberFormatException numberFormatException){
            logger.error("String To int 异常，{}",numberFormatException.toString());
            return new ResponseBean(40001,"passportId或riseId格式错误",null);
        }catch (NullPointerException nullPointerException){
            logger.error("妈的，空指针了，没找到UserInfo，{}",nullPointerException.toString());
            return new ResponseBean(40001,"参数错误: [ " + nullPointerException.getMessage() + " ]",null);
        }
        return new ResponseBean(10000,"添加学籍成功",classMemberRegistrations);
    }

    @GetMapping("/getUserLessonByPassportId")
    public ResponseBean getUserLessonByPassportId(Integer passportId){
        List<ClassMemberRegistration> classMemberRegistrations =  classMemberRegistrationService.getRegistrationByPassportId(passportId);
        List<Map<String,Object>> data = classMemberRegistrationService.getUserLessonInfoByRegistration(classMemberRegistrations);
        return new ResponseBean(10000,"查询成功",data);
    }

    @GetMapping("/resetLesson")
    public ResponseBean resetLesson(Integer passportId,String termScheduleCode,String lessonCode){
        classMemberRegistrationService.resetRegistration( passportId, termScheduleCode, lessonCode);
        return new ResponseBean(10000,"重置成功",null);
    }

    @GetMapping("/getOnlineUserInfo")
    public ResponseBean getOnlineUserInfo(String riseId){
        if(StringUtils.isBlank(riseId)){
            return new ResponseBean(40005,"参数错误,riseId 必填","riseId 必填");
        }
        Map<String,Object> result = new HashMap<>();
        UserInfo userInfo = userInfoService.getProUserInfoByRiseId(riseId);
        result.put("userInfo",userInfo);
        List<Map<String,Object>> data= classMemberRegistrationService.getProRegistrationByPassportId(userInfo.getPassportId());

        return new ResponseBean(10000,"success",data,userInfo);
    }

    @GetMapping("/getStudyProgress")
    public ResponseBean getStudyProgress(String lessonCode,String termScheduleCode ,String riseId){
        UserInfo userInfo = userInfoService.getProUserInfoByRiseId(riseId);
        return new ResponseBean(10000,"success",userLessonLearningRecordService.getUserLessonLearningRecord(userInfo.getPassportId(),termScheduleCode,lessonCode));
    }

}