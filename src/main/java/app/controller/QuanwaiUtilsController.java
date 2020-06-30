package app.controller;

import app.entity.QuanwaiUtils;
import app.entity.ResponseBean;
import app.service.QuanwaiUtilsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 圈外的web工具(QuanwaiUtils)表控制层
 *
 * @author makejava
 * @since 2020-06-17 15:35:48
 */
@RestController
@RequestMapping("/quanwaiUtils")
public class QuanwaiUtilsController {
    /**
     * 服务对象
     */
    @Resource
    private QuanwaiUtilsService quanwaiUtilsService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public QuanwaiUtils selectOne(Integer id) {
        return this.quanwaiUtilsService.queryById(id);
    }

    @GetMapping("/getAllUtils")
    public ResponseBean getAllUtils(Integer pageSize,Integer pageNum){
        List<QuanwaiUtils> quanwaiUtilsList = quanwaiUtilsService.queryAllByLimit((pageNum-1) * pageSize,pageSize * pageNum);
        return new ResponseBean(10000,"查询成功",quanwaiUtilsList);
    }

}