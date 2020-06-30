package app.common.job;

import app.dao.test.TestAccessTokenDao;
import app.entity.AccessToken;
import app.dao.pro.ProAccessTokenDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SyncAccessToken {
    private Logger logger = LoggerFactory.getLogger(SyncAccessToken.class);

    @Resource
    private TestAccessTokenDao testAccessTokenDao;

    @Resource
    private ProAccessTokenDao proAccessTokenDao;

//    @Scheduled(cron = "0 0 13 * * ?")
    public void syncToken(){
        List<AccessToken> accessTokenList = proAccessTokenDao.getAllTokenContent();
        for (AccessToken accessToken : accessTokenList
        ) {
            testAccessTokenDao.syncToken(accessToken.getServiceId(),accessToken.getAccessToken());
        }
    }

}
