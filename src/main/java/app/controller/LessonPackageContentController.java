package app.controller;

import app.entity.LessonPackageContent;
import app.entity.ResponseBean;
import app.service.LessonPackageContentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 课程包的内容表，包含板块和课程(LessonPackageContent)表控制层
 *
 * @author makejava
 * @since 2020-06-19 11:52:09
 */
@RestController
@RequestMapping("lessonPackageContent")
public class LessonPackageContentController {
    /**
     * 服务对象
     */
    @Resource
    private LessonPackageContentService lessonPackageContentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public LessonPackageContent selectOne(Integer id) {
        return this.lessonPackageContentService.queryById(id);
    }



}