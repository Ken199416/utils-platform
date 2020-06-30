package app.controller;

import app.entity.PlatformMenu;
import app.entity.ResponseBean;
import app.service.PlatformMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public ResponseBean getMenu(){
        return new ResponseBean(10000,"查询成功",platformMenuService.getAllMenu());
    }


}