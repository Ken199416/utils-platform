package app.controller;

import app.entity.PlatformMenu;
import app.entity.ResponseBean;
import app.entity.User;
import app.service.PlatformMenuService;
import app.service.UserService;
import app.utils.JwtTokenUtils;
import org.apache.http.HttpResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 平台的菜单(PlatformMenu)表控制层
 *
 * @author makejava
 * @since 2020-06-14 08:56:08
 */
@RestController
public class PlatformMenuController {
    /**
     * 服务对象
     */
    @Resource
    private PlatformMenuService platformMenuService;

    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PlatformMenu selectOne(Integer id) {
        return this.platformMenuService.queryById(id);
    }

    @GetMapping("/getMenu")
    public ResponseBean getMenu(HttpServletRequest request) {
        User user = userService.getUserById(Integer.parseInt(JwtTokenUtils.getTokenInfo(request.getHeader("Authorization")).getUid()));
        if (user.getUsername().equals("admin")){
            return new ResponseBean(10000,"查询成功",platformMenuService.getAllMenuAdmin());
        }else {
            return new ResponseBean(10000,"查询成功",platformMenuService.getAllMenu());
        }
    }


}