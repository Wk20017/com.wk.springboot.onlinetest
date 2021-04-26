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

    public User queryUserByUserId(String cardId){
        return userDao.queryUserByUserId(cardId);
    }

    public void update_join(User user){
        userDao.update_join(user);
    }

    public double getLastGrade(String cardId){
        return userDao.getLastGrade(cardId);
    }

    public void update_time(User user){
        userDao.update_time(user);
    }

    public void update_grade(String cardId, double grade){
        userDao.update_grade(cardId, grade);
    }

    public void update_count(String cardId, Integer rightCount){
        userDao.update_count(cardId, rightCount);
    }

    public void addUser(String cardId, String userName, String companyName){
        try {
            userDao.addUser(cardId, userName, companyName);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    public void deleteUser(String card_id){
//         userDao.deleteUser(card_id);
//    }

    //answer
    public List<Answer> queryAnswer(){
        return userDao.queryAnswer();
    }
}
