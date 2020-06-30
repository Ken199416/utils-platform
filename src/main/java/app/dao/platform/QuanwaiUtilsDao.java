package app.dao.platform;

import app.entity.QuanwaiUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 圈外的web工具(QuanwaiUtils)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-17 15:35:48
 */
@Mapper
@Component
public interface QuanwaiUtilsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    QuanwaiUtils queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<QuanwaiUtils> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param quanwaiUtils 实例对象
     * @return 对象列表
     */
    List<QuanwaiUtils> queryAll(QuanwaiUtils quanwaiUtils);

    /**
     * 新增数据
     *
     * @param quanwaiUtils 实例对象
     * @return 影响行数
     */
    int insert(QuanwaiUtils quanwaiUtils);

    /**
     * 修改数据
     *
     * @param quanwaiUtils 实例对象
     * @return 影响行数
     */
    int update(QuanwaiUtils quanwaiUtils);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}