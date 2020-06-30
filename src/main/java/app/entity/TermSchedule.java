package app.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.io.Serializable;

/**
 * 排期-排期表(TermSchedule)实体类
 *
 * @author makejava
 * @since 2020-06-16 22:22:06
 */
@Data
public class TermSchedule implements Serializable {
    private static final long serialVersionUID = -49136277217120194L;
    /**
    * 排期id
    */
    private Integer id;
    /**
    * 排期唯一标识code
    */
    private String code;
    /**
    * 课程包名称
    */
    private String lessonPackageName;
    /**
    * 课程包id
    */
    private Integer lessonPackageId;
    /**
    * 课程包code
    */
    private String lessonPackageCode;
    /**
    * 期数
    */
    private Integer term;
    /**
    * 报名开始时间
    */
    private Date applyStartTime;
    /**
    * 报名结束时间
    */
    private Date applyEndTime;
    /**
    * 课程包生效时间
    */
    private Date lessonPackageActiveTime;
    /**
    * 课程包过期时间
    */
    private Date lessonPackageExpiredTime;
    /**
    * 排期状态:
0:待报名,
1:报名中,
2:待开营,
3:已开营,
4:已结束,

    */
    private Integer termState;
    /**
    * 班级人数上限
    */
    private Integer classLimit;
    /**
    * 该期人数上限
    */
    private Integer termLimit;
    /**
    * 售卖年
    */
    private Integer sellingYear;
    /**
    * 售卖月
    */
    private Integer sellingMonth;
    /**
    * 学院类型
    */
    private Integer collegeType;
    /**
    * 课程包学习期(天）
    */
    private Integer studyCycle;
    /**
    * 课程包类型id
    */
    private Integer lessonPackageTypeId;
    /**
    * 预报名人数上限
    */
    private Integer preApplyMaximum;
    /**
    * 实际报名时间
    */
    private Date actualApplyStartTime;
    /**
    * 实际报名结束时间
    */
    private Date actualApplyEndTime;
    /**
    * 预报名
0 是
1 否
    */
    private Integer forecastName;
    /**
    * 是否强制切换下一期
0 是
1 否
    */
    private Integer forceNextIssue;
    /**
    * 是否排班，默认0排班，1不排班
    */
    private Integer classFlag;
    /**
    * 是否赠课，默认1不支持赠课，0支持赠课
    */
    private Integer givingFlag;
    /**
    * 状态
0 启用
1 删除
    */
    private Integer status;
    /**
    * 初始化数据状态0:初始化,1:未初始化
    */
    private Integer initStatus;
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
    /**
    * 老会员id
    */
    private Integer memberTypeId;
    /**
    * 上下架 0 上架 1下架
    */
    private Integer usageState;

    /**
     * 排期状态的描述
     */
    private String termStatusDesc;

    public String getTermStatusDesc(){
        if (termState == 0){
            return "待报名";
        }
        if (termState == 1){
            return "报名中";
        }
        if (termState == 2){
            return "待开营";
        }
        if (termState == 3){
            return "已开营";
        }
        if (termState == 4){
            return "已结营";
        }
        return null;
    }



}