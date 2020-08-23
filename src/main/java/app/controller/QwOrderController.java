package app.controller;

import app.entity.QwOrder;
import app.service.QwOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 订单表(QwOrder)表控制层
 *
 * @author makejava
 * @since 2020-07-07 11:45:58
 */
@RestController
@RequestMapping("qwOrder")
public class QwOrderController {
    /**
     * 服务对象
     */
    @Resource
    private QwOrderService qwOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public QwOrder selectOne(Integer id) {
        return this.qwOrderService.queryById(id);
    }

}