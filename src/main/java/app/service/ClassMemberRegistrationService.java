package app.service;

import app.entity.ClassMemberRegistration;
import java.util.List;
import java.util.Map;

/**
 * 学员学籍表(ClassMemberRegistration)表服务接口
 *
 * @author makejava
 * @since 2020-06-16 21:57:57
 */
public interface ClassMemberRegistrationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ClassMemberRegistration queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ClassMemberRegistration> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param classMemberRegistration 实例对象
     * @return 实例对象
     */
    ClassMemberRegistration insert(ClassMemberRegistration classMemberRegistration);

    /**
     * 修改数据
     *
     * @param classMemberRegistration 实例对象
     * @return 实例对象
     */
    ClassMemberRegistration update(ClassMemberRegistration classMemberRegistration);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 重置课程
     * @param passportId
     * @param termScheduleCode
     * @param lessonCode
     * @return
     */

    int resetRegistration(Integer passportId,String termScheduleCode,String lessonCode);


    List<ClassMemberRegistration> getRegistrationByPassportId(Integer passportId);

    List<Map<String,Object>> getUserLessonInfoByRegistration(List<ClassMemberRegistration> classMemberRegistrations);



}