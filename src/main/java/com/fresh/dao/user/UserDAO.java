package com.fresh.dao.user;

import com.fresh.model.user.User;
import com.fresh.model.user.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *  用户DAO
 */
@Service
public interface UserDAO {

    // 获取用户数据
    User getUser(User user);
    // 获取用户数据集合
    List<User> listUser(User user);
    // 获取用户分页数据集合
    List<User> listUserPage(UserVO userVO);
    // 获取用户总条数
    int countUserPageList(UserVO userVO);
    // 新增用户
    void saveUser(User user);
    // 修改用户
    void updateUser(User user);
    // 删除用户
    void removeUser(User user);

}
