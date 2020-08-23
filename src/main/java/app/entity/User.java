package app.entity;
import lombok.Data;

@Data
public class User {
    private int id;
    private int rid;
    private int parentRid;
    private boolean del;
    private String username;
//    不把用戶的加密后的密碼返回
    private String password;
    private String mobile;
    private String email;
    private String customerName;
    private int extendInfoId;
    private String address;
    private String company;
    private String department;
}
