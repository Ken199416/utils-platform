package app.service.impl;

import app.dao.platform.UserDao;
import app.entity.User;
import app.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public int editUser(User user) {
        return userDao.editUser(user);
    }



    public static Logger logger = LoggerFactory.getLogger(app.service.impl.UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Override
    public List<User> getUserBySearch(String query, int pageNum, int pageSize) {
        Map<String,Object> maps = new HashMap<>();
        maps.put("query",query);
        maps.put("start",(pageNum-1) * pageSize);
        maps.put("size",pageSize);
        return userDao.getUserBySearch(maps);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean userRegister(User user) {
        boolean result = true;
        try {
            userDao.register(user);
        }catch (Exception e){
            result = false;
            logger.error("数据库执行期间发生错误");
            logger.error(e.getStackTrace().toString());
        }
        return result;
    }

    @Override
    public List<User> getAllUser() {
        List<User> list = userDao.getAllUser();
        return list;
    }

    @Override
    public User getUserById(long id) {
        User user= userDao.getUserById(id);
        return user;
    }

    @Override
    public User getUserLogin(User user) {
        return userDao.getUserLogin(user);
    }

    @Override
    public int toDelUser(boolean flag, int uid) {
        Map<String,Object> map = new HashMap<>();
        map.put("uid",uid);
        map.put("flag",flag ? 1 : 0);
        return userDao.toDelUser(map);
    }

    @Override
    public long getUserCountByCustomer(String customerName) {
        Map<String,Object> maps = new HashMap<>();
        maps.put("query",customerName);
        return userDao.getUserCountByName(maps);
    }

    @Override
    public long getUserCount(User user) {
        return userDao.getUserCount(user);
    }
}
