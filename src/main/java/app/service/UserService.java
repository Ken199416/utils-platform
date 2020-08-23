package app.service;

import app.entity.User;

import java.util.List;


public interface UserService {
    public boolean userRegister(User user);
    List<User> getAllUser();
    List<User> getUserBySearch(String query, int pageNum, int pageSize);
    User getUserById(long id);
    User getUserLogin(User user);
    long getUserCount(User user);
    long getUserCountByCustomer(String customerName);
    int toDelUser(boolean flag, int uid);
    int addUser(User user);
    int editUser(User user);
}
