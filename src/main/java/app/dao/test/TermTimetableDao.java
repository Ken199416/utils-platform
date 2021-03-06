package app.dao.test;

import app.entity.TermTimetable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 排期-课表(TermTimetable)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-16 22:37:13
 */
@Mapper
@Component
public interface TermTimetableDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TermTimetable queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TermTimetable> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param termTimetable 实例对象
     * @return 对象列表
     */
    List<TermTimetable> queryAll(TermTimetable termTimetable);

    /**
     * 新增数据
     *
     * @param termTimetable 实例对象
     * @return 影响行数
     */
    int insert(TermTimetable termTimetable);

    /**
     * 修改数据
     *
     * @param termTimetable 实例对象
     * @return 影响行数
     */
    int update(TermTimetable termTimetable);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<TermTimetable> getTermTimeTablesBySchedule(String scheduleCode);


}