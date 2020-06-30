package app.controller;

import app.entity.ResponseBean;
import app.entity.UserInfo;
import app.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户基本信息(UserInfo)表控制层
 *
 * @author makejava
 * @since 2020-06-18 11:51:00
 */
@RestController
@RequestMapping("userInfo")
public class UserInfoController {
    private static Logger logger = LoggerFactory.getLogger(UserInfoController.class);
    /**
     * 服务对象
     */
    @Resource
    private UserInfoService userInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserInfo selectOne(Integer id) {
        return this.userInfoService.queryById(id);
    }


    @GetMapping("/test")
    public ResponseBean test(){
        logger.info("开始");
        try {
            Thread.sleep(1000 * 300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("结束");
        return new ResponseBean(10000,"等待结束，300s",null);
    }



}