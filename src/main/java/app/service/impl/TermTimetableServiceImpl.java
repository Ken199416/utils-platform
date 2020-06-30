package app.service.impl;

import app.entity.TermTimetable;
import app.dao.test.TermTimetableDao;
import app.service.TermTimetableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 排期-课表(TermTimetable)表服务实现类
 *
 * @author makejava
 * @since 2020-06-16 22:37:13
 */
@Service("termTimetableService")
public class TermTimetableServiceImpl implements TermTimetableService {
    @Resource
    private TermTimetableDao termTimetableDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TermTimetable queryById(Integer id) {
        return this.termTimetableDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TermTimetable> queryAllByLimit(int offset, int limit) {
        return this.termTimetableDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param termTimetable 实例对象
     * @return 实例对象
     */
    @Override
    public TermTimetable insert(TermTimetable termTimetable) {
        this.termTimetableDao.insert(termTimetable);
        return termTimetable;
    }

    /**
     * 修改数据
     *
     * @param termTimetable 实例对象
     * @return 实例对象
     */
    @Override
    public TermTimetable update(TermTimetable termTimetable) {
        this.termTimetableDao.update(termTimetable);
        return this.queryById(termTimetable.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.termTimetableDao.deleteById(id) > 0;
    }
}