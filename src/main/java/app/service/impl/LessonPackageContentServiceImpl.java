package app.service.impl;

import app.entity.LessonPackageContent;
import app.dao.test.LessonPackageContentDao;
import app.service.LessonPackageContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课程包的内容表，包含板块和课程(LessonPackageContent)表服务实现类
 *
 * @author makejava
 * @since 2020-06-19 11:52:09
 */
@Service("lessonPackageContentService")
public class LessonPackageContentServiceImpl implements LessonPackageContentService {
    @Resource
    private LessonPackageContentDao lessonPackageContentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public LessonPackageContent queryById(Integer id) {
        return this.lessonPackageContentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<LessonPackageContent> queryAllByLimit(int offset, int limit) {
        return this.lessonPackageContentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param lessonPackageContent 实例对象
     * @return 实例对象
     */
    @Override
    public LessonPackageContent insert(LessonPackageContent lessonPackageContent) {
        this.lessonPackageContentDao.insert(lessonPackageContent);
        return lessonPackageContent;
    }

    /**
     * 修改数据
     *
     * @param lessonPackageContent 实例对象
     * @return 实例对象
     */
    @Override
    public LessonPackageContent update(LessonPackageContent lessonPackageContent) {
        this.lessonPackageContentDao.update(lessonPackageContent);
        return this.queryById(lessonPackageContent.getId());
    }

    @Override
    public List<LessonPackageContent> getLessonInfoByLessonPackageId(Integer lessonPackageId) {
        return lessonPackageContentDao.getLessonInfoByLessonPackageId(lessonPackageId);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.lessonPackageContentDao.deleteById(id) > 0;
    }
}