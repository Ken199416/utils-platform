package app.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 平台的菜单(PlatformMenu)实体类
 *
 * @author makejava
 * @since 2020-06-14 08:56:08
 */

@Data
public class PlatformMenu implements Serializable {
    private static final long serialVersionUID = -43287592906027678L;
    
    private Integer id;
    /**
    * 父id
    */
    private Integer parentId;
    /**
    * 排序优先级
    */
    private Integer pri;
    /**
    * 菜单名称
    */
    private String menuName;
    /**
    * 路由地址
    */
    private String path;
    /**
    * 权限值，当用户有这些权限，才可以看到，操作这些
    */
    private String permissionValue;
    /**
    * 1：可用，其他：停用
    */
    private Boolean status;
    
    private Date createTime;
    
    private Date updateTime;

    private List<PlatformMenu> children;

    private String icon;

    private Boolean isAdmin;



}