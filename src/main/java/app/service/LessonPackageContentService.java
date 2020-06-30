package app.service;

import app.entity.LessonPackageContent;
import java.util.List;

/**
 * 课程包的内容表，包含板块和课程(LessonPackageContent)表服务接口
 *
 * @author makejava
 * @since 2020-06-19 11:52:09
 */
public interface LessonPackageContentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LessonPackageContent queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LessonPackageContent> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param lessonPackageContent 实例对象
     * @return 实例对象
     */
    LessonPackageContent insert(LessonPackageContent lessonPackageContent);

    /**
     * 修改数据
     *
     * @param lessonPackageContent 实例对象
     * @return 实例对象
     */
    LessonPackageContent update(LessonPackageContent lessonPackageContent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    /**
     * 根据课程包id查询相关课程
     * @param lessonPackageId
     * @return
     */

    List<LessonPackageContent> getLessonInfoByLessonPackageId(Integer lessonPackageId);
}