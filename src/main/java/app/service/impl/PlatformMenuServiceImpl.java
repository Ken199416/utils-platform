package app.service.impl;

import app.entity.PlatformMenu;
import app.dao.platform.PlatformMenuDao;
import app.service.PlatformMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 平台的菜单(PlatformMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-06-14 08:56:08
 */
@Service
public class PlatformMenuServiceImpl implements PlatformMenuService {
    @Autowired
    private PlatformMenuDao platformMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PlatformMenu queryById(Integer id) {
        return this.platformMenuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PlatformMenu> queryAllByLimit(int offset, int limit) {
        return this.platformMenuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param platformMenu 实例对象
     * @return 实例对象
     */
    @Override
    public PlatformMenu insert(PlatformMenu platformMenu) {
        this.platformMenuDao.insert(platformMenu);
        return platformMenu;
    }

    @Override
    public List<PlatformMenu> getAllMenu() {
//        先获取顶级的菜单，再通过顶级的菜单获取下级菜单
        List<PlatformMenu> platformMenuList = platformMenuDao.getAllMenu(0);
        for (PlatformMenu menu : platformMenuList
             ) {
            if(menu.getParentId() != null){
                List<PlatformMenu> childrenMenu = platformMenuDao.getAllMenu(menu.getId());
                menu.setChildren(childrenMenu);
            }
        }
        return platformMenuList;
    }

    /**
     * 修改数据
     *
     * @param platformMenu 实例对象
     * @return 实例对象
     */
    @Override
    public PlatformMenu update(PlatformMenu platformMenu) {
        this.platformMenuDao.update(platformMenu);
        return this.queryById(platformMenu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.platformMenuDao.deleteById(id) > 0;
    }
}