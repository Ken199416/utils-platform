package app.dao.platform;

import app.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface UserDao {
    void register(User user);
    List<User> getAllUser();
    User getUserById(long id);
    User getUserLogin(User user);
    long getUserCount(User user);
    List<User> getUserBySearch(@Param("params") Map params);
    long getUserCountByName(@Param("params") Map params);
    int toDelUser(@Param("params") Map params);
    int addUser(User user);
    int editUser(User user);
}
