package com.wk.springboot.dao;

import com.wk.springboot.vo.Answer;
import com.wk.springboot.vo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {

    User queryUserByUserId(@Param("cardId") String cardId);

//    void deleteUser(String card_id);


    int update_join(User user);
    int update_grade(String cardId, double myGrade);
    int update_count(String cardId, Integer myCount);
    int update_time(User user);

    double getLastGrade(@Param("cardId") String cardId);
    void addUser(@Param("cardId") String cardId, @Param("userName") String userName);

    List<Answer> queryAnswer();
}
