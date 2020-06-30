package app.service;

import app.entity.AccessToken;
import java.util.List;

/**
 * 公众号token(AccessToken)表服务接口
 *
 * @author makejava
 * @since 2020-06-13 08:57:18
 */
public interface AccessTokenService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AccessToken queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AccessToken> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param accessToken 实例对象
     * @return 实例对象
     */
    AccessToken insert(AccessToken accessToken);

    /**
     * 修改数据
     *
     * @param accessToken 实例对象
     * @return 实例对象
     */
    AccessToken update(AccessToken accessToken);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    void sync();

}