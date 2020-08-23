package app.service.impl;

import app.dao.pro.ProLessonPackageDao;
import app.entity.LessonPackage;
import app.dao.test.LessonPackageDao;
import app.service.LessonPackageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 课程集合(LessonPackage)表服务实现类
 *
 * @author makejava
 * @since 2020-06-16 22:09:26
 */
@Service
public class LessonPackageServiceImpl implements LessonPackageService {
    @Resource
    private LessonPackageDao lessonPackageDao;

    @Resource
    private ProLessonPackageDao proLessonPackageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public LessonPackage queryById(Integer id) {
        return this.lessonPackageDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<LessonPackage> queryAllByLimit(int offset, int limit) {
        return this.lessonPackageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param lessonPackage 实例对象
     * @return 实例对象
     */
    @Override
    public LessonPackage insert(LessonPackage lessonPackage) {
        this.lessonPackageDao.insert(lessonPackage);
        return lessonPackage;
    }

    /**
     * 修改数据
     *
     * @param lessonPackage 实例对象
     * @return 实例对象
     */
    @Override
    public LessonPackage update(LessonPackage lessonPackage) {
        this.lessonPackageDao.update(lessonPackage);
        return this.queryById(lessonPackage.getId());
    }

    @Override
    public List<Map<String, Object>> getProPackageAcquireRules(String lessonPackageCode ,String acquireLessonPackageCodes) {
        List<Map<String, Object>> result = new ArrayList<>();
        if (StringUtils.isBlank(acquireLessonPackageCodes)){
            result = proLessonPackageDao.getPackageAcquireRules(lessonPackageCode,null);
        }else {
            List<String> acquireLessonPackageCodeList = Arrays.asList(acquireLessonPackageCodes.split(","));
            result = proLessonPackageDao.getPackageAcquireRules(lessonPackageCode, acquireLessonPackageCodeList);
        }
//        String createTime = null;
//        for (Map<String,Object> map : result) {
//            for (String key : map.keySet()) {
//                if (key.equals("create_time")){
//                    createTime = map.get(key).toString();
//
//                }
//            }
//        }
        return result;
    }

    @Override
    public List<LessonPackage> getProAllLessonPackage() {
        return proLessonPackageDao.getAllLessonPackage();
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.lessonPackageDao.deleteById(id) > 0;
    }

    @Override
    public LessonPackage getProLessonById(Integer id) {
        return proLessonPackageDao.queryById(id);
    }
}