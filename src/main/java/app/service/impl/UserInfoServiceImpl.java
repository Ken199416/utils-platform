package app.service.impl;

import app.dao.pro.ProUserInfoDao;
import app.entity.UserInfo;
import app.dao.test.UserInfoDao;
import app.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户基本信息(UserInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-06-18 11:51:00
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Resource
    private ProUserInfoDao proUserInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserInfo queryById(Integer id) {
        return this.userInfoDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserInfo> queryAllByLimit(int offset, int limit) {
        return this.userInfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    @Override
    public UserInfo insert(UserInfo userInfo) {
        this.userInfoDao.insert(userInfo);
        return userInfo;
    }

    @Override
    public UserInfo getProUserInfoByRiseId(String riseId) {

        return proUserInfoDao.getUserByRiseId(riseId);
    }

    /**
     * 修改数据
     *
     * @param userInfo 实例对象
     * @return 实例对象
     */
    @Override
    public UserInfo update(UserInfo userInfo) {
        this.userInfoDao.update(userInfo);
        return this.queryById(userInfo.getId());
    }

    @Override
    public UserInfo getUserByPassportId(Integer passportId) {
        return userInfoDao.getUserByPassportId(passportId);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userInfoDao.deleteById(id) > 0;
    }
}