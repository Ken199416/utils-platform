package app.controller;

import app.entity.JWTInfo;
import app.entity.ResponseBean;
import app.entity.User;
import app.service.UserService;
import app.utils.CommonUtils;
import app.utils.JwtTokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;


    /**
     *  添加本地库，创建数据库
     */




    @RequestMapping("/login")
    public ResponseBean login(@RequestBody User user){
        logger.info("登录信息：username={} , password={}",user.getUsername(),user.getPassword());
        User resultUser = userService.getUserLogin(user);
        ResponseBean responseBean = new ResponseBean();
        if ( resultUser != null && CommonUtils.verifyPassword(user.getPassword(),resultUser.getPassword())){
            logger.info("登录成功，登录信息：" + resultUser.toString());
            String token = JwtTokenUtils.generatorToken(new JWTInfo(resultUser.getId()+""));
            responseBean.setMsg("登录成功");
            responseBean.setCode(10000);
            responseBean.setData(userService.getUserById(resultUser.getId()));
            responseBean.setExtend(token);
            return responseBean;
        }
        logger.info("登录失败");
        responseBean.setMsg("登陆失败，请检查用户名和密码");
        responseBean.setCode(9999);
        return responseBean;
    }

    @RequestMapping("other")
    public ResponseBean other(){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setMsg("拦截器测试");
        responseBean.setCode(6666);
        return responseBean;
    }


    @RequestMapping("/queryUser")
    public Map<String,Object> getUsers(String query , int pageNum , int pageSize){
        List<User> userList = userService.getUserBySearch(query,pageNum,pageSize);
        Map<String,Object> resultList = new HashMap<>();
        resultList.put("code",10000);
        resultList.put("msg","查询成功");
        resultList.put("data",CommonUtils.getUserInfoList(userList));
        resultList.put("total",userService.getUserCountByCustomer(query));
        return resultList;
    }

    @RequestMapping("/toDelUser")
    public ResponseBean toDelUser(boolean flag, int uid){
        ResponseBean responseBean = new ResponseBean();
        int len = userService.toDelUser(flag,uid);
        if(len == -1){
            responseBean.setCode(9999);
            responseBean.setMsg("更新用户状态失败");
            return responseBean;
        }
        responseBean.setCode(10000);
        responseBean.setMsg("更新用户状态成功");
        return responseBean;
    }

    @RequestMapping("/addUser")
    public ResponseBean addUser(@RequestBody User user){
        logger.info(user.toString());
        user.setPassword(CommonUtils.encoderPassword(user.getPassword()));
        ResponseBean responseBean = new ResponseBean();
        if (StringUtils.isBlank(user.getUsername()) && StringUtils.isBlank(user.getUsername())  &&
                StringUtils.isBlank(user.getCustomerName()) &&  StringUtils.isBlank(user.getMobile()) && StringUtils.isBlank(user.getEmail())){
            responseBean.setMsg("参数错误");
            responseBean.setCode(40001);
            return responseBean;
        }
        int len = userService.addUser(user);
        if (len != -1){
            responseBean.setCode(10000);
            responseBean.setMsg("添加成功");
            return responseBean;
        }
        responseBean.setMsg("添加失败");
        responseBean.setCode(99999);
        return responseBean;
    }

    @RequestMapping("/editUser")
    public ResponseBean editUser(@RequestBody User user){
        ResponseBean responseBean = new ResponseBean();
        logger.info(user.toString());
        if (StringUtils.isBlank(user.getUsername()) && StringUtils.isBlank(user.getCustomerName()) &&
                StringUtils.isBlank(user.getMobile()) && StringUtils.isBlank(user.getEmail())){
            responseBean.setMsg("参数错误");
            responseBean.setCode(40001);
            return responseBean;
        }
        int len = userService.editUser(user);
        if (len != -1){
            responseBean.setCode(10000);
            responseBean.setMsg("更新用户信息成功");
            return responseBean;
        }
        responseBean.setMsg("更新失败");
        responseBean.setCode(99999);
        return responseBean;
    }

}
