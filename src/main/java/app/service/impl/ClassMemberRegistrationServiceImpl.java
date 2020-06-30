package app.service.impl;

import app.dao.test.LessonPackageDao;
import app.dao.test.TermScheduleDao;
import app.dao.test.UserInfoDao;
import app.entity.*;
import app.dao.test.ClassMemberRegistrationDao;
import app.service.ClassMemberRegistrationService;
import app.service.LessonPackageContentService;
import app.service.TermScheduleService;
import app.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 学员学籍表(ClassMemberRegistration)表服务实现类
 *
 * @author makejava
 * @since 2020-06-16 21:57:57
 */
@Service
public class ClassMemberRegistrationServiceImpl implements ClassMemberRegistrationService {
    @Resource
    private ClassMemberRegistrationDao classMemberRegistrationDao;

    @Resource
    private LessonPackageDao lessonPackageDao;

    @Resource
    private TermScheduleDao termScheduleDao;

    @Resource
    private UserInfoDao userInfoDao;

    @Resource
    private LessonPackageContentService lessonPackageContentService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ClassMemberRegistration queryById(Integer id) {
        return this.classMemberRegistrationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ClassMemberRegistration> queryAllByLimit(int offset, int limit) {
        return this.classMemberRegistrationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param classMemberRegistration 实例对象
     * @return 实例对象
     */
    @Override
    public ClassMemberRegistration insert(ClassMemberRegistration classMemberRegistration) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmm");
        UserInfo userInfo = userInfoDao.getUserByPassportId(classMemberRegistration.getPassportId());
        LessonPackage lessonPackage = lessonPackageDao.queryById(classMemberRegistration.getLessonPackageId());
        TermSchedule termSchedule = termScheduleDao.queryById(classMemberRegistration.getTermScheduleId());
        classMemberRegistration.setRegistrationId(lessonPackage.getCode().substring(0,2)+simpleDateFormat.format(new Date())+ new Random().nextInt(9));
        classMemberRegistration.setRiseId(userInfo.getRiseId());
        classMemberRegistration.setOrderId("20061600030" + simpleDateFormat.format(new Date()));
        classMemberRegistration.setGoodsCode("69048" + simpleDateFormat.format(new Date()));
        if (termSchedule.getTermState() == 1 || termSchedule.getTermState() == 2){
            classMemberRegistration.setRegistrationStage(0);
        }else if(termSchedule.getTermState() == 3){
            classMemberRegistration.setRegistrationStage(1);
        }else if(termSchedule.getTermState() == 4){
            classMemberRegistration.setRegistrationStage(2);
        }
        classMemberRegistration.setRegistrationState(0);
        classMemberRegistration.setLessonPackageCode(lessonPackage.getCode());
        classMemberRegistration.setTermScheduleCode(termSchedule.getCode());
        classMemberRegistration.setActiveTime(termSchedule.getLessonPackageActiveTime());
        classMemberRegistration.setExpireTime(termSchedule.getLessonPackageExpiredTime());
        classMemberRegistration.setApproach(0);
        classMemberRegistration.setEnterSourceTermId(0);
        classMemberRegistration.setExtensionCode("");
        classMemberRegistration.setChannelTypeId(0);
        classMemberRegistration.setChannelGroupId(0);
        classMemberRegistration.setChannelId(0);
        classMemberRegistration.setStatus(0);
        classMemberRegistration.setCreatedBy("None");
        classMemberRegistration.setModifiedBy("None");
        classMemberRegistrationDao.insert(classMemberRegistration);
        return classMemberRegistration;
    }

    /**
     * 修改数据
     *
     * @param classMemberRegistration 实例对象
     * @return 实例对象
     */
    @Override
    public ClassMemberRegistration update(ClassMemberRegistration classMemberRegistration) {
        this.classMemberRegistrationDao.update(classMemberRegistration);
        return this.queryById(classMemberRegistration.getId());
    }

    @Override
    public int resetRegistration(Integer passportId, String termScheduleCode, String lessonCode) {
        int result = classMemberRegistrationDao.resetLessonInfo(passportId,termScheduleCode,lessonCode);
        if (result > 0){
            classMemberRegistrationDao.deleteLessonCompletion(passportId,termScheduleCode,lessonCode);
            classMemberRegistrationDao.deleteLessonContentLearningRecord(passportId,termScheduleCode,lessonCode);
            classMemberRegistrationDao.deleteLessonThoughtLearningRecord(passportId,termScheduleCode,lessonCode);
            classMemberRegistrationDao.deleteLessonContentCompletion(passportId,termScheduleCode,lessonCode);
            classMemberRegistrationDao.deleteChoiceQuestionLearningRecord(passportId,termScheduleCode,lessonCode);
            classMemberRegistrationDao.deleteEssayQuestionLearningRecord(passportId,termScheduleCode,lessonCode);
            result = classMemberRegistrationDao.deleteLessonChapterSectionLearningRecord(passportId,termScheduleCode,lessonCode);
            return result;
        }
        return result;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.classMemberRegistrationDao.deleteById(id) > 0;
    }

    @Override
    public List<Map<String, Object>> getUserLessonInfoByRegistration(List<ClassMemberRegistration> classMemberRegistrations) {
        List<Map<String,Object>> userLessonInfoList = new ArrayList<>();
        classMemberRegistrations.forEach(classMemberRegistration -> {
            Map<String,Object> map = new HashMap<>();
            LessonPackage lessonPackage = lessonPackageDao.queryById(classMemberRegistration.getLessonPackageId());
            TermSchedule termSchedule = termScheduleDao.queryById(classMemberRegistration.getTermScheduleId());
            List<LessonPackageContent> lessonPackageContents = lessonPackageContentService.getLessonInfoByLessonPackageId(classMemberRegistration.getLessonPackageId());
            map.put("lessonPackageName",lessonPackage.getName());
            map.put("lessonPackageId",classMemberRegistration.getLessonPackageId());
            map.put("termScheduleCode",termSchedule.getCode());
            map.put("termScheduleId",classMemberRegistration.getTermScheduleId());
            map.put("term",termSchedule.getTerm());
            map.put("lessonList",lessonPackageContents);
            userLessonInfoList.add(map);
        });
        return userLessonInfoList;
    }

    @Override
    public List<ClassMemberRegistration> getRegistrationByPassportId(Integer passportId){
        return classMemberRegistrationDao.getRegistrationByPassportId(passportId);
    }
}