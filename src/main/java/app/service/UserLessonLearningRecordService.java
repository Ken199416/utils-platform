package app.service;

import app.entity.UserLessonLearningRecord;
import java.util.List;
import java.util.Map;

/**
 * 用户的课程记录表(UserLessonLearningRecord)表服务接口
 *
 * @author makejava
 * @since 2020-07-05 10:25:12
 */
public interface UserLessonLearningRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserLessonLearningRecord queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserLessonLearningRecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userLessonLearningRecord 实例对象
     * @return 实例对象
     */
    UserLessonLearningRecord insert(UserLessonLearningRecord userLessonLearningRecord);

    /**
     * 修改数据
     *
     * @param userLessonLearningRecord 实例对象
     * @return 实例对象
     */
    UserLessonLearningRecord update(UserLessonLearningRecord userLessonLearningRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    Map<String,Object> getUserLessonLearningRecord(Integer passportId, String termScheduleCode, String lessonCode);


    int getLessonSectionTotal(Integer lessonId);


}