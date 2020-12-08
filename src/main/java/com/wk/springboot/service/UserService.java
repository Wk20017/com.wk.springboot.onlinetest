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

    public void update_grade(String cardId, double grade){
        userDao.update_grade(cardId, grade);
    }

    public void update_count(String cardId, Integer right_count){
        userDao.update_count(cardId, right_count);
    }


//    public void deleteUser(String card_id){
//         userDao.deleteUser(card_id);
//    }

    //answer
    public List<Answer> queryAnswer(){
        return userDao.queryAnswer();
    }
}
