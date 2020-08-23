package app.dao.pro;

import app.entity.QwOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 订单表(QwOrder)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-07 11:45:58
 */
@Component
@Mapper
public interface ProQwOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    QwOrder queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<QwOrder> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param qwOrder 实例对象
     * @return 对象列表
     */
    List<QwOrder> queryAll(QwOrder qwOrder);

    /**
     * 新增数据
     *
     * @param qwOrder 实例对象
     * @return 影响行数
     */
    int insert(QwOrder qwOrder);

    /**
     * 修改数据
     *
     * @param qwOrder 实例对象
     * @return 影响行数
     */
    int update(QwOrder qwOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    QwOrder queryByOrderId(String orderId);
}