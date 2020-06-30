package app.controller;

import app.entity.TermTimetable;
import app.service.TermTimetableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 排期-课表(TermTimetable)表控制层
 *
 * @author makejava
 * @since 2020-06-16 22:37:13
 */
@RestController
@RequestMapping("termTimetable")
public class TermTimetableController {
    /**
     * 服务对象
     */
    @Resource
    private TermTimetableService termTimetableService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TermTimetable selectOne(Integer id) {
        return this.termTimetableService.queryById(id);
    }

}