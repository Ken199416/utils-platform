package app.controller;

import app.entity.LessonPackage;
import app.entity.ResponseBean;
import app.service.LessonPackageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 课程集合(LessonPackage)表控制层
 *
 * @author makejava
 * @since 2020-06-16 22:09:26
 */
@RestController
@RequestMapping("lessonPackage")
public class LessonPackageController {
    /**
     * 服务对象
     */
    @Resource
    private LessonPackageService lessonPackageService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public LessonPackage selectOne(Integer id) {
        return this.lessonPackageService.queryById(id);
    }


    @GetMapping("/getAllPackage")
    public ResponseBean getAllPackage(){
        return new ResponseBean(10000,"查询成功",lessonPackageService.queryAllByLimit(0,1000));
    }

}