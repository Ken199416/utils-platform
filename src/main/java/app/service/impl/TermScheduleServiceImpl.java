package app.service.impl;

import app.entity.TermSchedule;
import app.dao.test.TermScheduleDao;
import app.entity.TermScheduleEnum;
import app.service.TermScheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 排期-排期表(TermSchedule)表服务实现类
 *
 * @author makejava
 * @since 2020-06-16 22:22:06
 */
@Service("termScheduleService")
public class TermScheduleServiceImpl implements TermScheduleService {
    @Resource
    private TermScheduleDao termScheduleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TermSchedule queryById(Integer id) {
        return this.termScheduleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TermSchedule> queryAllByLimit(int offset, int limit) {
        return this.termScheduleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param termSchedule 实例对象
     * @return 实例对象
     */
    @Override
    public TermSchedule insert(TermSchedule termSchedule) {
        this.termScheduleDao.insert(termSchedule);
        return termSchedule;
    }

    /**
     * 修改数据
     *
     * @param termSchedule 实例对象
     * @return 实例对象
     */
    @Override
    public TermSchedule update(TermSchedule termSchedule) {
        this.termScheduleDao.update(termSchedule);
        return this.queryById(termSchedule.getId());
    }

    @Override
    public List<TermSchedule> getTermScheduleByLessonPackage(Integer lessonPackageId) {
        return termScheduleDao.getTermScheduleByLessonPackage(lessonPackageId);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.termScheduleDao.deleteById(id) > 0;
    }
}