package app.service;

import app.entity.QuanwaiUtils;
import java.util.List;

/**
 * 圈外的web工具(QuanwaiUtils)表服务接口
 *
 * @author makejava
 * @since 2020-06-17 15:35:48
 */
public interface QuanwaiUtilsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    QuanwaiUtils queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<QuanwaiUtils> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param quanwaiUtils 实例对象
     * @return 实例对象
     */
    QuanwaiUtils insert(QuanwaiUtils quanwaiUtils);

    /**
     * 修改数据
     *
     * @param quanwaiUtils 实例对象
     * @return 实例对象
     */
    QuanwaiUtils update(QuanwaiUtils quanwaiUtils);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}