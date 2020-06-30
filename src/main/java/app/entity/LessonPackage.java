package app.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 课程集合(LessonPackage)实体类
 *
 * @author makejava
 * @since 2020-06-16 22:09:26
 */
@Data
public class LessonPackage implements Serializable {
    private static final long serialVersionUID = -64045834340980146L;
    
    private Integer id;
    /**
    * 编码
    */
    private String code;
    /**
    * 名称
    */
    private String name;
    /**
    * 课程包缩写
    */
    private String abbreviation;
    /**
    * 描述
    */
    private String description;
    /**
    * 学院类型
    */
    private Integer collegeType;
    /**
    * 学院类型的名称
    */
    private String collegeName;
    /**
    * 课程包类型，从lesson_package_type表关联过来
    */
    private Integer type;
    /**
    * 课程包类型的名称
    */
    private String typeName;
    /**
    * 学习周期(天)
    */
    private Integer studyCycle;
    /**
    * 状态(上下架)
    */
    private Integer status;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 创建人
    */
    private String createdBy;
    /**
    * 修改人
    */
    private String modifiedBy;
    
    private Integer istest;



}