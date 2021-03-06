package app.service;

import app.entity.TermTimetable;
import java.util.List;

/**
 * 排期-课表(TermTimetable)表服务接口
 *
 * @author makejava
 * @since 2020-06-16 22:37:13
 */
public interface TermTimetableService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TermTimetable queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TermTimetable> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param termTimetable 实例对象
     * @return 实例对象
     */
    TermTimetable insert(TermTimetable termTimetable);

    /**
     * 修改数据
     *
     * @param termTimetable 实例对象
     * @return 实例对象
     */
    TermTimetable update(TermTimetable termTimetable);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}