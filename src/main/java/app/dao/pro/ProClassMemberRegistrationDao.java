package app.dao.pro;

import app.entity.ClassMemberRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 学员学籍表(ClassMemberRegistration)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-16 21:57:57
 */
@Mapper
@Component
public interface ProClassMemberRegistrationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClassMemberRegistration queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ClassMemberRegistration> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param classMemberRegistration 实例对象
     * @return 对象列表
     */
    List<ClassMemberRegistration> queryAll(ClassMemberRegistration classMemberRegistration);

    /**
     * 新增数据
     *
     * @param classMemberRegistration 实例对象
     * @return 影响行数
     */
    int insert(ClassMemberRegistration classMemberRegistration);

    /**
     * 修改数据
     *
     * @param classMemberRegistration 实例对象
     * @return 影响行数
     */
    int update(ClassMemberRegistration classMemberRegistration);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int resetLessonInfo(Integer passportId,String termScheduleCode,String lessonCode);

    int deleteLessonCompletion(Integer passportId,String termScheduleCode,String lessonCode);

    int deleteLessonContentLearningRecord(Integer passportId,String termScheduleCode,String lessonCode);

    int deleteLessonThoughtLearningRecord(Integer passportId,String termScheduleCode,String lessonCode);

    int deleteLessonContentCompletion(Integer passportId,String termScheduleCode,String lessonCode);

    int deleteChoiceQuestionLearningRecord(Integer passportId,String termScheduleCode,String lessonCode);

    int deleteEssayQuestionLearningRecord(Integer passportId,String termScheduleCode,String lessonCode);

    int deleteLessonChapterSectionLearningRecord(Integer passportId,String termScheduleCode,String lessonCode);



    List<ClassMemberRegistration> getRegistrationByPassportId(Integer passportId);
}