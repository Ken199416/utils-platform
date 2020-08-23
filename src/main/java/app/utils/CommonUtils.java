package app.utils;

import app.entity.User;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommonUtils {

    private static Logger logger = LoggerFactory.getLogger(app.utils.CommonUtils.class);


    public static String cron = "0/15 * * * * ? *";

    public static final String PARAMS_COL_FLAG = "@@@";
    public static final String PARAMS_ROW_FLAG = "####";
    public static final String ASSERT_FLAG = "<==>";
    public static final  String ASSERT_NO = "*";
    public static final String  JWT_KEY_USER_ID = "uid";




//    全局等待时间
    public static final int TIME_WAIT_SECOND = 3;

    public static String encoderPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static boolean verifyPassword(String password,String encoderPassword){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password,encoderPassword);
    }

    public static User getUserInfo(User user){
        User userInfo = new User();
        userInfo.setAddress(user.getAddress());
        userInfo.setCompany(user.getCompany());
        userInfo.setCustomerName(user.getCustomerName());
        userInfo.setDel(user.isDel());
        userInfo.setId(user.getId());
        userInfo.setUsername(user.getUsername());
        userInfo.setEmail(user.getEmail());
        userInfo.setMobile(user.getMobile());
        userInfo.setDepartment(user.getDepartment());
        return userInfo;
    }

    public static List<User> getUserInfoList(List<User> userList) {
        List<User> list = new ArrayList<>();
        for (User user : userList) {
            list.add(getUserInfo(user));
        }
        return list;
    }

//  使用断言标志和报文，解析出需要断言的字符串
    public static String getResponseAssertString(String response,String assertFlag){
        String [] assertFlagArr = assertFlag.split("\\.");
        JSONObject jsonObject = null;
        JSONArray jsonArray = null;
        for (String string : assertFlagArr){
            if (string.contains("[")){
//                获取索引的长度
                int indexLength = string.indexOf("]") - string.indexOf("[");
                jsonObject = JSONObject.parseObject(response);
//                按照索引长度进行截取Key
                String key = (string.substring(0,string.length()- (indexLength + 1)));
                jsonArray = JSONArray.parseArray(jsonObject.getString(key));
                int index = Integer.parseInt(string.substring(string.indexOf("[") + 1,string.indexOf("[") + indexLength));
                jsonObject = jsonArray.getJSONObject(index);
                response = jsonObject.toJSONString();
            }else {
                jsonObject = JSONObject.parseObject(response);
                response = jsonObject.getString(string);
            }
        }
        return response;

    }

    

    public static int getCurrentUserId(HttpServletRequest request){
        return Integer.parseInt(JwtTokenUtils.getTokenInfo(request.getHeader("Authorization")).getUid());
    }


}
