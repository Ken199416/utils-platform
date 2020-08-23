package app.dao.test;

import app.entity.UserLessonLearningRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户的课程记录表(UserLessonLearningRecord)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-05 10:25:12
 */
public interface UserLessonLearningRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserLessonLearningRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserLessonLearningRecord> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userLessonLearningRecord 实例对象
     * @return 对象列表
     */
    List<UserLessonLearningRecord> queryAll(UserLessonLearningRecord userLessonLearningRecord);

    /**
     * 新增数据
     *
     * @param userLessonLearningRecord 实例对象
     * @return 影响行数
     */
    int insert(UserLessonLearningRecord userLessonLearningRecord);

    /**
     * 修改数据
     *
     * @param userLessonLearningRecord 实例对象
     * @return 影响行数
     */
    int update(UserLessonLearningRecord userLessonLearningRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    UserLessonLearningRecord getUserLessonLearningRecord(Integer passportId, String termScheduleCode, String lessonCode);


    int getLessonSectionTotal(Integer lessonId);

}