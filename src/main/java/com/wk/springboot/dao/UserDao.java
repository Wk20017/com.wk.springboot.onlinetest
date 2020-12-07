package com.wk.springboot.dao;

import com.wk.springboot.vo.Answer;
import com.wk.springboot.vo.User;

import java.util.List;

public interface UserDao {

    User queryUserByUserId(String card_id);

    void deleteUser(String card_id);


    int update_join(User user);
    int update_grade(User user, Integer grade);
    int update_count(User user, Integer count);
    int update_time(User user);


    List<Answer> queryAnswer();
}
