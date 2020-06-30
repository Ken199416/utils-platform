package app.controller;

import app.entity.ResponseBean;
import app.entity.TermSchedule;
import app.service.TermScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 排期-排期表(TermSchedule)表控制层
 *
 * @author makejava
 * @since 2020-06-16 22:22:06
 */
@RestController
@RequestMapping("termSchedule")
public class TermScheduleController {
    /**
     * 服务对象
     */
    @Resource
    private TermScheduleService termScheduleService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TermSchedule selectOne(Integer id) {
        return this.termScheduleService.queryById(id);
    }


    @GetMapping("/getTermSchedule")
    public ResponseBean getTermSchedule(Integer lessonPackageId){
        return new ResponseBean(10000,"查询成功",termScheduleService.getTermScheduleByLessonPackage(lessonPackageId));
    }

}