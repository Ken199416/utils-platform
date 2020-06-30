package app.service;

import app.entity.TermSchedule;
import java.util.List;

/**
 * 排期-排期表(TermSchedule)表服务接口
 *
 * @author makejava
 * @since 2020-06-16 22:22:06
 */
public interface TermScheduleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TermSchedule queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TermSchedule> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param termSchedule 实例对象
     * @return 实例对象
     */
    TermSchedule insert(TermSchedule termSchedule);

    /**
     * 修改数据
     *
     * @param termSchedule 实例对象
     * @return 实例对象
     */
    TermSchedule update(TermSchedule termSchedule);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<TermSchedule> getTermScheduleByLessonPackage(Integer lessonPackageId);

}