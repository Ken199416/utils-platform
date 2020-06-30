package app.controller;

import app.entity.AccessToken;
import app.entity.ResponseBean;
import app.service.AccessTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 公众号token(AccessToken)表控制层
 *
 * @author makejava
 * @since 2020-06-13 08:57:46
 */
@RestController
@RequestMapping("accessToken")
public class AccessTokenController {
    private static Logger logger = LoggerFactory.getLogger(AccessTokenController.class);

    /**
     * 服务对象
     */
    @Resource
    private AccessTokenService accessTokenService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public AccessToken selectOne(Integer id) {
        return this.accessTokenService.queryById(id);
    }


    @GetMapping("/sync")
    public ResponseBean sync(){
        try {
            accessTokenService.sync();
        }catch (Exception e){
            logger.error("同步token失败");
            e.printStackTrace();
            return new ResponseBean(4004,"同步token失败",e.getMessage());
        }
        return new ResponseBean(10000,"同步token成功",null);
    }

}