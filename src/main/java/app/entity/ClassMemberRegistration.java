package app.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 学员学籍表(ClassMemberRegistration)实体类
 *
 * @author makejava
 * @since 2020-06-16 21:57:57
 */
@Data
public class ClassMemberRegistration implements Serializable {
    private static final long serialVersionUID = 985436934967103447L;
    /**
    * 学籍id
    */
    private Integer id;
    /**
    * 学籍编号
    */
    private String registrationId;
    /**
    * 用户编码
    */
    private String riseId;
    /**
    * 用户唯一标识
    */
    private Integer passportId;
    /**
    * 订单id
    */
    private String orderId;
    /**
    * 商品编码
    */
    private String goodsCode;
    /**
    * 学籍阶段 已报名:0 已开营:1 已结营:2 已毕业:3
    */
    private Integer registrationStage;
    /**
    * 学籍状态: 学籍开启:0 学籍关闭:1 学籍已变更:2
    */
    private Integer registrationState;
    /**
    * 课程包id
    */
    private Integer lessonPackageId;
    /**
    * 课程包code
    */
    private String lessonPackageCode;
    /**
    * 期数id
    */
    private Integer termScheduleId;
    /**
    * 期数唯一标识
    */
    private String termScheduleCode;
    /**
    * 学籍生效时间
    */
    private Date activeTime;
    /**
    * 学籍过期时间
    */
    private Date expireTime;
    /**
    * 学员进入此排期的来源，0 正常报名，1延期，2休学，3人工操作，4插班，5恢复
    */
    private Integer approach;
    /**
    * 该学籍的来源排期，正常报名时为0

    */
    private Integer enterSourceTermId;
    /**
    * 推广编码
    */
    private String extensionCode;
    /**
    * 渠道类型id
    */
    private Integer channelTypeId;
    /**
    * 渠道分组id
    */
    private Integer channelGroupId;
    /**
    * 渠道id
    */
    private Integer channelId;
    /**
    * 状态
0 启用
1 删除
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
    /**
     * 学籍状态
     */
    private String RegistrationStatusDesc;

    public String getRegistrationStatusDesc(){
        return RegistrationEnum.getRegistrationStatusDesc(this.getRegistrationState());
    }



    private String type;

    private String value;


}