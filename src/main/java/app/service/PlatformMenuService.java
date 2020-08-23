package app.service;

import app.entity.PlatformMenu;
import java.util.List;

/**
 * 平台的菜单(PlatformMenu)表服务接口
 *
 * @author makejava
 * @since 2020-06-14 08:56:08
 */
public interface PlatformMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PlatformMenu queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PlatformMenu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param platformMenu 实例对象
     * @return 实例对象
     */
    PlatformMenu insert(PlatformMenu platformMenu);

    /**
     * 修改数据
     *
     * @param platformMenu 实例对象
     * @return 实例对象
     */
    PlatformMenu update(PlatformMenu platformMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    /**
     * 查询所有菜单
     */
    List<PlatformMenu> getAllMenu();
    List<PlatformMenu> getAllMenuAdmin();

}