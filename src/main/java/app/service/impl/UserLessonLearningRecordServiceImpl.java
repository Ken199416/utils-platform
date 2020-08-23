package app.service.impl;

import app.dao.pro.ProUserLessonCompletionDao;
import app.dao.test.UserLessonLearningRecordDao;
import app.entity.UserLessonLearningRecord;
import app.dao.pro.ProUserLessonLearningRecordDao;
import app.service.UserLessonLearningRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户的课程记录表(UserLessonLearningRecord)表服务实现类
 *
 * @author makejava
 * @since 2020-07-05 10:25:12
 */
@Service
public class UserLessonLearningRecordServiceImpl implements UserLessonLearningRecordService {
    @Resource
    private ProUserLessonLearningRecordDao proUserLessonLearningRecordDao;

    @Resource
    private ProUserLessonCompletionDao proUserLessonCompletionDao;

    @Resource
    private UserLessonLearningRecordDao userLessonLearningRecordDao;



    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserLessonLearningRecord queryById(Integer id) {
        return this.proUserLessonLearningRecordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserLessonLearningRecord> queryAllByLimit(int offset, int limit) {
        return this.proUserLessonLearningRecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userLessonLearningRecord 实例对象
     * @return 实例对象
     */
    @Override
    public UserLessonLearningRecord insert(UserLessonLearningRecord userLessonLearningRecord) {
        this.proUserLessonLearningRecordDao.insert(userLessonLearningRecord);
        return userLessonLearningRecord;
    }

    /**
     * 修改数据
     *
     * @param userLessonLearningRecord 实例对象
     * @return 实例对象
     */
    @Override
    public UserLessonLearningRecord update(UserLessonLearningRecord userLessonLearningRecord) {
        this.proUserLessonLearningRecordDao.update(userLessonLearningRecord);
        return this.queryById(userLessonLearningRecord.getId());
    }

    @Override
    public int getLessonSectionTotal(Integer lessonId) {
        return userLessonLearningRecordDao.getLessonSectionTotal(lessonId);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.proUserLessonLearningRecordDao.deleteById(id) > 0;
    }

    @Override
    public Map<String,Object> getUserLessonLearningRecord(Integer passportId, String termScheduleCode, String lessonCode) {
        Map<String,Object> data = new HashMap<>();
        data.put("userLessonLearningRecord",proUserLessonLearningRecordDao.getUserLessonLearningRecord(passportId,termScheduleCode,lessonCode));
        data.put("userLessonCompletion",proUserLessonCompletionDao.getUserLessonCompletion(passportId,termScheduleCode,lessonCode));
        return data;
    }
}