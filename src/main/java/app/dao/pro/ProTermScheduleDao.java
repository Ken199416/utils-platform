package app.dao.pro;

import app.entity.TermSchedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 排期-排期表(TermSchedule)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-16 22:22:06
 */
@Mapper
@Component
public interface ProTermScheduleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TermSchedule queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TermSchedule> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param termSchedule 实例对象
     * @return 对象列表
     */
    List<TermSchedule> queryAll(TermSchedule termSchedule);

    /**
     * 新增数据
     *
     * @param termSchedule 实例对象
     * @return 影响行数
     */
    int insert(TermSchedule termSchedule);

    /**
     * 修改数据
     *
     * @param termSchedule 实例对象
     * @return 影响行数
     */
    int update(TermSchedule termSchedule);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    List<TermSchedule> getTermScheduleByLessonPackage(Integer lessonPackageId);

}