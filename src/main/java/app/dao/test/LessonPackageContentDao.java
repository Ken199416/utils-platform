package app.dao.test;

import app.entity.LessonPackageContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 课程包的内容表，包含板块和课程(LessonPackageContent)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-19 11:52:09
 */
@Mapper
@Component
public interface LessonPackageContentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LessonPackageContent queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LessonPackageContent> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param lessonPackageContent 实例对象
     * @return 对象列表
     */
    List<LessonPackageContent> queryAll(LessonPackageContent lessonPackageContent);

    /**
     * 新增数据
     *
     * @param lessonPackageContent 实例对象
     * @return 影响行数
     */
    int insert(LessonPackageContent lessonPackageContent);

    /**
     * 修改数据
     *
     * @param lessonPackageContent 实例对象
     * @return 影响行数
     */
    int update(LessonPackageContent lessonPackageContent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    List<LessonPackageContent> getLessonInfoByLessonPackageId(Integer lessonPackageId);

}