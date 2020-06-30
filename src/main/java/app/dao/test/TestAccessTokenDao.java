package app.dao.test;

import app.entity.AccessToken;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import sun.awt.image.VSyncedBSManager;

import java.util.List;

/**
 * 公众号token(AccessToken)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-13 08:57:18
 */
@Mapper
@Component
public interface TestAccessTokenDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AccessToken queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<AccessToken> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param accessToken 实例对象
     * @return 对象列表
     */
    List<AccessToken> queryAll(AccessToken accessToken);

    /**
     * 新增数据
     *
     * @param accessToken 实例对象
     * @return 影响行数
     */
    int insert(AccessToken accessToken);

    /**
     * 修改数据
     *
     * @param accessToken 实例对象
     * @return 影响行数
     */
    int update(AccessToken accessToken);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<AccessToken> getAllTokenContent();


    void syncToken(Integer serviceId,String accessToken);
}