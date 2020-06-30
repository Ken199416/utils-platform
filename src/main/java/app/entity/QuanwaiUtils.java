package app.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 圈外的web工具(QuanwaiUtils)实体类
 *
 * @author makejava
 * @since 2020-06-17 15:35:48
 */
@Data
public class QuanwaiUtils implements Serializable {
    private static final long serialVersionUID = 203354550900024494L;
    
    private Integer id;
    
    private String utilsName;
    /**
    * 工具的打开方式：
1、dialog弹窗
2、router路由页面
    */
    private Integer openType;
    /**
    * 如果open_type == 2,该字段才生效
    */
    private String path;
    
    private Boolean status;
    
    private Date createTime;
    
    private Date updateTime;
    
    private String utilsDescribe;



}