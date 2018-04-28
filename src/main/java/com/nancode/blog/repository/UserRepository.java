package com.nancode.blog.repository;

import com.nancode.blog.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sufun
 * Date: 2018/4/28 上午11:00
 * Description:
 */
public interface UserRepository {

    /**
     * 创建或者修改用户
     *
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);


    /**
     * 删除用户
     *
     * @param id
     */
    void deleteUser(Long id);


    /**
     * 查询用户
     *
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 用户列表
     *
     * @return
     */
    List<User> listUsers();
}
