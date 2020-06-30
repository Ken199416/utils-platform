package app.service;

import app.entity.LessonPackage;
import java.util.List;

/**
 * 课程集合(LessonPackage)表服务接口
 *
 * @author makejava
 * @since 2020-06-16 22:09:26
 */
public interface LessonPackageService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LessonPackage queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LessonPackage> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param lessonPackage 实例对象
     * @return 实例对象
     */
    LessonPackage insert(LessonPackage lessonPackage);

    /**
     * 修改数据
     *
     * @param lessonPackage 实例对象
     * @return 实例对象
     */
    LessonPackage update(LessonPackage lessonPackage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}