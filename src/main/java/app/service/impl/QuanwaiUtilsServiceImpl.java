package app.service.impl;

import app.entity.QuanwaiUtils;
import app.dao.platform.QuanwaiUtilsDao;
import app.service.QuanwaiUtilsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 圈外的web工具(QuanwaiUtils)表服务实现类
 *
 * @author makejava
 * @since 2020-06-17 15:35:48
 */
@Service("quanwaiUtilsService")
public class QuanwaiUtilsServiceImpl implements QuanwaiUtilsService {
    @Resource
    private QuanwaiUtilsDao quanwaiUtilsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public QuanwaiUtils queryById(Integer id) {
        return this.quanwaiUtilsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<QuanwaiUtils> queryAllByLimit(int offset, int limit) {
        return this.quanwaiUtilsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param quanwaiUtils 实例对象
     * @return 实例对象
     */
    @Override
    public QuanwaiUtils insert(QuanwaiUtils quanwaiUtils) {
        this.quanwaiUtilsDao.insert(quanwaiUtils);
        return quanwaiUtils;
    }

    /**
     * 修改数据
     *
     * @param quanwaiUtils 实例对象
     * @return 实例对象
     */
    @Override
    public QuanwaiUtils update(QuanwaiUtils quanwaiUtils) {
        this.quanwaiUtilsDao.update(quanwaiUtils);
        return this.queryById(quanwaiUtils.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.quanwaiUtilsDao.deleteById(id) > 0;
    }
}