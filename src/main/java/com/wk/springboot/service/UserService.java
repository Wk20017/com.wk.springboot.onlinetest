package com.wk.springboot.service;

import com.wk.springboot.dao.UserDao;
import com.wk.springboot.vo.Answer;
import com.wk.springboot.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired(required = false)
    private UserDao userDao;

    public User queryUserByUserId(String card_id){
        return userDao.queryUserByUserId(card_id);
    }

    public void update_join(User user){
        userDao.update_join(user);
    }

    public void update_time(User user){
        userDao.update_time(user);
    }

    public void update_grade(User user, Integer grade){
        userDao.update_grade(user, grade);
    }

    public void update_count(User user, Integer right_count){
        userDao.update_count(user, right_count);
    }
    public void deleteUser(String card_id){
         userDao.deleteUser(card_id);
    }

    //answer
    public List<Answer> queryAnswer(){
        return userDao.queryAnswer();
    }
}
