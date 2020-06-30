package app.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 公众号token(AccessToken)实体类
 *
 * @author makejava
 * @since 2020-06-13 08:57:18
 */
@Data
public class AccessToken implements Serializable {
    private static final long serialVersionUID = 733635204960617095L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 平台类型:  0 公众号 1小程序 ...
    */
    private Integer platformId;
    /**
    * 第三方应用主键ID
    */
    private Integer appConfigId;
    /**
    * 服务号id
    */
    private Integer serviceId;
    /**
    * 公众号原始ID
    */
    private String originId;
    /**
    * 第三方应用名称
    */
    private String appName;
    /**
    * 第三方token:如微信API调用token
    */
    private String accessToken;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 状态 0 正常  1 失效
    */
    private Boolean status;


}