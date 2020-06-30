package app.service.impl;

import app.entity.AccessToken;
import app.dao.test.TestAccessTokenDao;
import app.service.AccessTokenService;
import org.springframework.stereotype.Service;
import app.dao.pro.ProAccessTokenDao;
import javax.annotation.Resource;
import java.util.List;

/**
 * 公众号token(AccessToken)表服务实现类
 *v
 * @author makejava
 * @since 2020-06-13 08:57:18
 */
@Service
public class AccessTokenServiceImpl implements AccessTokenService {
    @Resource
    private TestAccessTokenDao testAccessTokenDao;

    @Resource
    private ProAccessTokenDao proAccessTokenDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AccessToken queryById(Integer id) {
        return this.testAccessTokenDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<AccessToken> queryAllByLimit(int offset, int limit) {
        return this.testAccessTokenDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param accessToken 实例对象
     * @return 实例对象
     */
    @Override
    public AccessToken insert(AccessToken accessToken) {
        this.testAccessTokenDao.insert(accessToken);
        return accessToken;
    }

    @Override
    public void sync() {
        List<AccessToken> accessTokenList = proAccessTokenDao.getAllTokenContent();
        for (AccessToken accessToken : accessTokenList
        ) {
            testAccessTokenDao.syncToken(accessToken.getServiceId(),accessToken.getAccessToken());
        }
    }

    /**
     * 修改数据
     *
     * @param accessToken 实例对象
     * @return 实例对象
     */
    @Override
    public AccessToken update(AccessToken accessToken) {
        this.testAccessTokenDao.update(accessToken);
        return this.queryById(accessToken.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.testAccessTokenDao.deleteById(id) > 0;
    }
}