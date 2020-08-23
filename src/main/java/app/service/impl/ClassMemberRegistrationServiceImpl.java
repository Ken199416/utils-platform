package app.service.impl;

import app.dao.pro.*;
import app.dao.test.*;
import app.entity.*;
import app.service.ClassMemberRegistrationService;
import app.service.LessonPackageContentService;
import app.service.QwOrderService;
import app.service.UserLessonLearningRecordService;
import org.apache.commons.lang3.StringUtils;
import org.mockito.internal.matchers.Null;
import org.mockito.internal.matchers.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    private static Logger logger = LoggerFactory.getLogger(ClassMemberRegistrationServiceImpl.class);
    @Resource
    private ClassMemberRegistrationDao classMemberRegistrationDao;

    @Resource
    private QwOrderService qwOrderService;

    @Resource
    private LessonPackageDao lessonPackageDao;

    @Resource
    private TermScheduleDao termScheduleDao;

    @Resource
    private UserInfoDao userInfoDao;

    @Resource
    private ProTermScheduleDao proTermScheduleDao;

    @Resource
    private ProLessonPackageContentDao proLessonPackageContentDao;

    @Resource
    private LessonPackageContentService lessonPackageContentService;

    @Resource
    private ProClassMemberRegistrationDao proClassMemberRegistrationDao;

    @Resource
    private ProOrderDao proOrderDao;

    @Resource
    private ProTermTimetableDao proTermTimetableDao;

    @Resource
    private UserLessonLearningRecordDao userLessonLearningRecordDao;


    @Resource
    private TermTimetableDao termTimetableDao;


    @Resource
    private UserLessonLearningRecordService userLessonLearningRecordService;

//    获取全部的学籍相关信息
    @Override
    public List<Map<String, Object>> getProRegistrationByPassportId(Integer passportId) {
        List<Map<String,Object>> result = new ArrayList<>();
//        先获取全部学籍信息
        List<ClassMemberRegistration> classMemberRegistrations = proClassMemberRegistrationDao.getRegistrationByPassportId(passportId);
//        根据学籍，拼装数据
        for (ClassMemberRegistration classMemberRegistration : classMemberRegistrations) {
            Map<String,Object> data = new HashMap<>();
//            排期数据
            TermSchedule termSchedule = proTermScheduleDao.queryById(classMemberRegistration.getTermScheduleId());
//            课程包内容
//            List<LessonPackageContent> lessonPackageContents = proLessonPackageContentDao.getLessonInfoByLessonPackageId(classMemberRegistration.getLessonPackageId());
//          订单的信息
            Map<String,String> orderInfo = new HashMap<>();
            QwOrder order = qwOrderService.queryByOrderId(classMemberRegistration.getOrderId());
            if (StringUtils.isNoneBlank(classMemberRegistration.getOrderId()) && order != null){
                orderInfo.put("orderId",order.getOrderId());
                orderInfo.put("orderStatus",OrderStatusEnum.getOrderStatusDesc((int)order.getOrderStatus()));
            }else {
                orderInfo.put("orderId","无");
                orderInfo.put("orderStatus","无");
            }
//          课表信息
            List<TermTimetable> termTimetables = proTermTimetableDao.queryBySchedule(termSchedule.getCode());





            data.put("termSchedule",termSchedule);
            data.put("orderInfo",orderInfo);
            data.put("lessonContents",termTimetables);
            data.put("registration",classMemberRegistration);
            result.add(data);
        }
        return result;
    }

    @Override
    public List<ClassMemberRegistration> insertByType(ClassMemberRegistration classMemberRegistration) throws NullPointerException{
        List<ClassMemberRegistration> classMemberRegistrations = new ArrayList<>();
        List<UserInfo> userInfos = new ArrayList<>();
        String [] values = classMemberRegistration.getValue().split(",");
        UserInfo userInfo = null;
        boolean flag = classMemberRegistration.getType().equals("passportId");
        for (String value : values) {
            if (flag){
                logger.info("用passport_id开课");
                userInfo = userInfoDao.getUserByPassportId(Integer.parseInt(value));
            }else {
                logger.info("用rise_id开课");
                userInfo = userInfoDao.getUserByRiseId(value);
            }
            if (userInfo == null){
                logger.error("没查到用户");
                throw new NullPointerException(flag ? "passport_id:" : "rise_id:" + value);
            }
            userInfos.add(userInfo);
        }
        logger.info("参数校验通过，开始添加...");
        for (UserInfo user : userInfos) {
            classMemberRegistration.setPassportId(user.getPassportId());
            classMemberRegistrations.add(insert(classMemberRegistration));
        }
        return classMemberRegistrations;
    }

    @Override
    public List<Map<String, Object>> getProUserLessonInfoByRegistration(List<ClassMemberRegistration> classMemberRegistrations) {
//        List<Map<String,Object>> userLessonInfoList = new ArrayList<>();
//        classMemberRegistrations.forEach(classMemberRegistration -> {
//            Map<String,Object> map = new HashMap<>();
//            LessonPackage lessonPackage = lessonPackageDao.queryById(classMemberRegistration.getLessonPackageId());
//            TermSchedule termSchedule = termScheduleDao.queryById(classMemberRegistration.getTermScheduleId());
//            List<LessonPackageContent> lessonPackageContents = lessonPackageContentService.getLessonInfoByLessonPackageId(classMemberRegistration.getLessonPackageId());
//            map.put("lessonPackageName",lessonPackage.getName());
//            map.put("lessonPackageId",classMemberRegistration.getLessonPackageId());
//            map.put("termScheduleCode",termSchedule.getCode());
//            map.put("termScheduleId",classMemberRegistration.getTermScheduleId());
//            map.put("term",termSchedule.getTerm());
//            map.put("lessonList",lessonPackageContents);
//            userLessonInfoList.add(map);
//        });
//        return userLessonInfoList;
        return null;
    }

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
//        添加学习记录 user_lesson_learning_record
//        通过课表添加
        List<TermTimetable> termTimetables = termTimetableDao.getTermTimeTablesBySchedule(classMemberRegistration.getTermScheduleCode());
        UserLessonLearningRecord userLessonLearningRecord = new UserLessonLearningRecord();
        for (TermTimetable termTimeTable : termTimetables) {
            userLessonLearningRecord.setPassportId(classMemberRegistration.getPassportId());
            userLessonLearningRecord.setRiseId(classMemberRegistration.getRiseId());
            userLessonLearningRecord.setRegistrationId(classMemberRegistration.getRegistrationId());
            userLessonLearningRecord.setTermTimetableId(termTimeTable.getId());
            userLessonLearningRecord.setTermScheduleId(classMemberRegistration.getTermScheduleId());
            userLessonLearningRecord.setTermScheduleCode(classMemberRegistration.getTermScheduleCode());
            userLessonLearningRecord.setLessonPackageId(classMemberRegistration.getLessonPackageId());
            userLessonLearningRecord.setLessonPackageCode(classMemberRegistration.getLessonPackageCode());
            userLessonLearningRecord.setLessonId(termTimeTable.getLessonId());
            userLessonLearningRecord.setLessonCode(termTimeTable.getLessonCode());
            userLessonLearningRecord.setLessonType(termTimeTable.getLessonType());
            userLessonLearningRecord.setTitle(termTimeTable.getLessonTitle());
            userLessonLearningRecord.setSectionProgress(0);
//            要做很特别的判断
            userLessonLearningRecord.setSectionTotal(userLessonLearningRecordDao.getLessonSectionTotal(termTimeTable.getLessonId()));
            userLessonLearningRecord.setProgress(0);
            userLessonLearningRecord.setUnlockFlag(0);
            userLessonLearningRecord.setBulletBox(0);
            userLessonLearningRecord.setStep(0);
            userLessonLearningRecord.setStatus(0);
            userLessonLearningRecord.setCreateTime(new Date());
            userLessonLearningRecord.setUpdateTime(new Date());
            userLessonLearningRecordDao.insert(userLessonLearningRecord);
        }
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