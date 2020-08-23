package app.dao.test;

import app.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * 用户基本信息(UserInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-18 11:51:00
 */

@Component
@Mapper
public interface UserInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserInfo queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userInfo 实例对象
     * @return 对象列表
     */
    List<UserInfo> queryAll(UserInfo userInfo);

    /**
     * 新增数据
     *
     * @param userInfo 实例对象
     * @return 影响行数
     */
    int insert(UserInfo userInfo);

    /**
     * 修改数据
     *
     * @param userInfo 实例对象
     * @return 影响行数
     */
    int update(UserInfo userInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    UserInfo getUserByPassportId(Integer passportId);

    UserInfo getUserByRiseId(String riseId);

}