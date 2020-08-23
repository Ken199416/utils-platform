package app.service;

import app.entity.QwOrder;
import java.util.List;

/**
 * 订单表(QwOrder)表服务接口
 *
 * @author makejava
 * @since 2020-07-07 11:45:58
 */
public interface QwOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    QwOrder queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<QwOrder> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param qwOrder 实例对象
     * @return 实例对象
     */
    QwOrder insert(QwOrder qwOrder);

    /**
     * 修改数据
     *
     * @param qwOrder 实例对象
     * @return 实例对象
     */
    QwOrder update(QwOrder qwOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    QwOrder queryByOrderId(String orderId);

}