package com.wk.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.wk.springboot.model.Msg;
import com.wk.springboot.service.UserService;
import com.wk.springboot.vo.Answer;
import com.wk.springboot.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("user/{card_id}")
    public User queryUserByUserId(@PathVariable String card_id){
        return userService.queryUserByUserId(card_id);
    }

    @RequestMapping("/mylogin")
    public String index(Model model){
        return "login";
    }

    @GetMapping("/login")
    public Msg login(String card_id, String user_name){
        User user1 = userService.queryUserByUserId(card_id);
//        System.out.println(card_id + user_name);
        Msg msg = new Msg();
        if(user1==null || !user1.getUserName().equals(user_name)){
            //输入错误，请重新输入
            System.out.println("no");
            msg.setCode(-1);
            msg.setMsg("验证失败");
            return msg;
        } else {
            //跳转到答题界面
            System.out.println("ok");
            msg.setCode(200);
            msg.setMsg("登录成功");
            return msg;
        }
    }

    @PostMapping("/user")
    @ResponseBody
    public void update_user(@RequestBody User user){
        //更新是否参加和用时
        userService.update_join(user);
        userService.update_time(user);

        //查询成绩表，计算并统计分数
        List<Answer> answer = userService.queryAnswer();
        int count = 0;
        double grade = 0;
        for (Answer i:answer){
            System.out.println(i.getAnswer());
            //判断用户输入与正确答案是否相同，相同count++, grade+相应分数;
        }
        //更新分数和正确数量
        userService.update_count(user.getCardId(), count);
        userService.update_grade(user.getCardId(), grade);
    }

//    @GetMapping("answer")
//    public void test(){
//        //查询成绩表，计算并统计分数
//        List<Answer> answer = userService.queryAnswer();
//        for (Answer i:answer){
//            System.out.println(i.getAnswer());
//        }
//    }

//    @DeleteMapping("delete_user/{card_id}")
//    public void deleteUser(@PathVariable String card_id){
//         userService.deleteUser(card_id);
//    }

}
