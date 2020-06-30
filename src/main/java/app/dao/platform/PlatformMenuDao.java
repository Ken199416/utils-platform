package app.dao.platform;

import app.entity.PlatformMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 平台的菜单(PlatformMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-14 08:56:08
 */
@Component
@Mapper
public interface PlatformMenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PlatformMenu queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PlatformMenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param platformMenu 实例对象
     * @return 对象列表
     */
    List<PlatformMenu> queryAll(PlatformMenu platformMenu);

    /**
     * 新增数据
     *
     * @param platformMenu 实例对象
     * @return 影响行数
     */
    int insert(PlatformMenu platformMenu);

    /**
     * 修改数据
     *
     * @param platformMenu 实例对象
     * @return 影响行数
     */
    int update(PlatformMenu platformMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<PlatformMenu> getAllMenu(Integer parentId);

}