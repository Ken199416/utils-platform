package app.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户基本信息(UserInfo)实体类
 *
 * @author makejava
 * @since 2020-06-18 11:50:59
 */

@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -71907342517219107L;
    
    private Integer id;
    /**
    * 用户 id
    */
    private Integer passportId;
    /**
    * 用户编码
    */
    private String riseId;
    /**
    * 用户类型 0: normal 1: 公司员工 2: 测试人员
    */
    private Integer userType;
    /**
    * 昵称
    */
    private String nickName;
    /**
    * 真实名称
    */
    private String realName;
    /**
    * 学号,已废弃
    */
    private String memberId;
    /**
    * 微信id
    */
    private String wechat;
    /**
    * 签名
    */
    private String signature;
    /**
    * 0: 单身 1: 已婚 2: 恋爱中 3: 保密
    */
    private Integer emotionStatus;
    /**
    * 手机号
    */
    private String mobile;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 性别，0:未知  1:男 2:女
    */
    private Integer sex;
    /**
    * 生日
    */
    private Date birthday;
    /**
    * 国家编码
    */
    private String countryCode;
    /**
    * 国家
    */
    private String country;
    /**
    * 省份编码
    */
    private String provinceCode;
    /**
    * 省份
    */
    private String province;
    /**
    * 城市编码
    */
    private String cityCode;
    /**
    * 城市
    */
    private String city;
    /**
    * 0: 未知 1: 小学 2: 初中 3: 高中 4: 专科 5: 本科 6: 研究生 7: 博士 8: 博士后 9: 教授
    */
    private Integer education;
    /**
    * 就业状态. 0: 学生 1: 工作者 2: 无业
    */
    private Integer jobStatus;
    /**
    * 毕业院校
    */
    private String college;
    /**
    * 公司名称
    */
    private String company;
    /**
    * 行业
    */
    private String industry;
    /**
    * 职业
    */
    private String profession;
    /**
    * 职位
    */
    private String position;
    /**
    * 职级 0: 其他 1: 目前不在职场 2:普通员工 3: 承担管理权限的资深员工 4: 部门负责人 5: 一线主管 6: 公司高管 7:CEO/公司创始人/董事
    */
    private Integer positionLevel;
    /**
    * 开始工作年份
    */
    private Integer workYear;
    /**
    * 【渠道信息】渠道码
    */
    private String channelCode;
    /**
    * 订单来源,冗余字段，就是渠道类型
    */
    private String channelType;
    /**
    * 渠道类型Id
    */
    private Integer channelTypeId;
    /**
    * 渠道分组
    */
    private String channelGroup;
    /**
    * 渠道分组Id
    */
    private Integer channelGroupId;
    /**
    * 渠道名称
    */
    private String channelName;
    /**
    * 状态
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
    * 更新时间
    */
    private Date updateTime;
    /**
    * 推广码
    */
    private String extensionCode;




}