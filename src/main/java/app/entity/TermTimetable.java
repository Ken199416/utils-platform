package app.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 排期-课表(TermTimetable)实体类
 *
 * @author makejava
 * @since 2020-06-16 22:37:13
 */
@Data
public class TermTimetable implements Serializable {
    private static final long serialVersionUID = -54872137730730309L;
    /**
    * 课表id
    */
    private Integer id;
    /**
    * 课表code
    */
    private String code;
    /**
    * 排期id
    */
    private Integer scheduleId;
    /**
    * 排期code
    */
    private String scheduleCode;
    /**
    * 课程包id
    */
    private Integer lessonPackageId;
    /**
    * 课程包唯一标识code
    */
    private String lessonPackageCode;
    /**
    * 课程包内关联课程的id
    */
    private Integer termLessonPackageContentId;
    /**
    * 课程所属板块的名称
    */
    private String lessonPlateName;
    /**
    * 课程id
    */
    private Integer lessonId;
    /**
    * 课程code
    */
    private String lessonCode;
    /**
    * 课程名
    */
    private String lessonTitle;
    /**
    * 开课时间
    */
    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date lessonOpeningTime;
    /**
    * 课程结束时间
    */
    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date lessonEndTime;
    /**
    * 课程类型
0 主修课
1 辅修课
    */
    private Integer lessonType;
    /**
    * 课程解锁规则
    */
    private Integer lessonUnlockRule;
    /**
    * 课程完课规则
    */
    private Integer lessonFinishRule;
    /**
    * 解锁规则（天）
    */
    private Integer day;
    /**
    * 解锁规则（节）
    */
    private Integer section;
    /**
    * 课程有效期类型，0 和课程包有效期一致，1 指定过期天数
    */
    private Integer expireType;
    /**
    * 课程过期天数，仅在expire_type为1时有效
    */
    private Integer expire;
    /**
    * 状态
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


    private String finishRule;

    public String getFinishRule(){
        return LessonFinishRuleEnum.getLessonFinishRuleDesc(this.lessonFinishRule);
    }

    private String unlockRule;

    public String getUnlockRule(){
//        顺序解锁
        if (this.lessonUnlockRule == 1){
            return "顺序解锁";
        }else {
//            指定
            return "开课后" + this.day + "天解锁" + this.section + "小节";
        }
    }


    public String getLessonTypeName(){
        if (this.lessonType == 0){
            return "主修课";
        }else {
            return "辅修课";
        }
    }




}