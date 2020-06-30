package app.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 课程包的内容表，包含板块和课程(LessonPackageContent)实体类
 *
 * @author makejava
 * @since 2020-06-19 11:52:09
 */
@Data
public class LessonPackageContent implements Serializable {
    private static final long serialVersionUID = 350814420964650812L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 课程集合id
    */
    private Integer lessonPackageId;
    /**
    * 课程包唯一编码
    */
    private String lessonPackageCode;
    /**
    * 课程id
    */
    private Integer lessonId;
    /**
    * 课程唯一编码
    */
    private String lessonCode;
    /**
    * 课程包的目录的名称
    */
    private String name;
    /**
    * 课程包的目录的类型，0是目录，1是课程
    */
    private Integer type;
    /**
    * 课程类型,0主修课，1辅修课
目录是否默认，1默认，0普通
    */
    private Integer lessonType;
    /**
    * 课程类型名称，主修 / 辅修
    */
    private String lessonTypeName;
    /**
    * 父目录的id
    */
    private Integer parentId;
    /**
    * 排序
    */
    private Integer sequence;
    /**
    * 完课规则id
    */
    private Integer finishRuleId;
    /**
    * 完课规则编码
    */
    private String finishRuleCode;
    /**
    * 完课规则名称
    */
    private String finishRuleName;
    /**
    * 开课规则id
    */
    private Integer startRuleId;
    /**
    * 开课规则编码
    */
    private String startRuleCode;
    /**
    * 开课规则表达式
    */
    private String startRuleCron;
    /**
    * 开课时间描述
    */
    private String startRuleDesc;
    /**
    * 课程有效期类型，0 和课程包有效期一致，1 指定过期天数
    */
    private Integer expireType;
    /**
    * 课程过期天数，仅在expire_type为1时有效
    */
    private Integer expire;
    /**
    * 状态，0有效 1无效
    */
    private Integer status;
    /**
    * 创建人
    */
    private String createdBy;
    /**
    * 修改人
    */
    private String modifiedBy;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;



}