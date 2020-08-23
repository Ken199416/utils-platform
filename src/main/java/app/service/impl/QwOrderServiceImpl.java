package app.service.impl;

import app.entity.QwOrder;
import app.dao.pro.ProQwOrderDao;
import app.service.QwOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单表(QwOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-07-07 11:45:58
 */
@Service
public class QwOrderServiceImpl implements QwOrderService {
    @Resource
    private ProQwOrderDao proQwOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public QwOrder queryById(Integer id) {
        return this.proQwOrderDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<QwOrder> queryAllByLimit(int offset, int limit) {
        return this.proQwOrderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param qwOrder 实例对象
     * @return 实例对象
     */
    @Override
    public QwOrder insert(QwOrder qwOrder) {
        this.proQwOrderDao.insert(qwOrder);
        return qwOrder;
    }

    @Override
    public QwOrder queryByOrderId(String orderId) {
        return proQwOrderDao.queryByOrderId(orderId);
    }

    /**
     * 修改数据
     *
     * @param qwOrder 实例对象
     * @return 实例对象
     */
    @Override
    public QwOrder update(QwOrder qwOrder) {
        this.proQwOrderDao.update(qwOrder);
        return this.queryById(qwOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.proQwOrderDao.deleteById(id) > 0;
    }
}