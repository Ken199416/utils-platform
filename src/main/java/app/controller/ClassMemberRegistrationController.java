package app.controller;

import app.entity.ClassMemberRegistration;
import app.entity.ResponseBean;
import app.service.ClassMemberRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.management.ObjectName;
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
        logger.info("未添加前的学籍信息：{}",classMemberRegistration.toString());
        classMemberRegistrationService.insert(classMemberRegistration);
        logger.info("添加后的学籍信息：{}",classMemberRegistration.toString());
        return new ResponseBean(10000,"添加学籍成功",classMemberRegistration);
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

}