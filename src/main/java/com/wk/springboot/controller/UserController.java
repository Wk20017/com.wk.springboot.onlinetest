package com.wk.springboot.controller;

import com.wk.springboot.model.Msg;
import com.wk.springboot.service.UserService;
import com.wk.springboot.vo.Answer;
import com.wk.springboot.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("user/{cardId}")
    public User queryUserByUserId(@PathVariable String cardId) {
        return userService.queryUserByUserId(cardId);
    }

    @RequestMapping("/")
    public String index(Model model) {
        return "login";
    }

    @GetMapping("/login")
    @ResponseBody
    public Msg login(String cardId, String userName, String companyName) {
        System.out.println("companyName:" + companyName);
        User user1 = userService.queryUserByUserId(cardId);
        if (user1 == null){
            userService.addUser(cardId, userName, companyName);
            user1 = userService.queryUserByUserId(cardId);
        }
//        System.out.println(card_id + user_name);
        Msg msg = new Msg();
        System.out.println(userName+"请求登录..");
        if (user1 == null || !user1.getUserName().equals(userName)) {
            //输入错误，请重新输入
            System.out.println("no");
            msg.setCode("-1");
            msg.setMsg("验证失败");
            return msg;
        } else if (user1.getIsJoin() == 2) {
            System.out.println("No");
            msg.setCode("-1");
            msg.setMsg("两次机会已用完！");
            return msg;
        } else {
            //跳转到答题界面
            System.out.println("ok");
            msg.setCode("200");
            msg.setMsg("登录成功");
            return msg;
        }
    }

    @PostMapping("/user")
    @ResponseBody
    public Msg update_user(@RequestBody User user) {
        Msg msg = new Msg();
        if(userService.queryUserByUserId(user.getCardId()).getIsJoin()==2){
            msg.setCode("-2");
            msg.setMsg("两次机会已用完！");
            return msg;
        }

        //查询成绩表，计算并统计分数
        List<Answer> answer = userService.queryAnswer();
        List<String> user_answer = user.getT();
        int count = 0;
        double grade = 0;
        int flag = 0;
        for (Answer i : answer) {
            if(user_answer.get(flag).equals(i.getAnswer())){
                count++;
                grade += 2;
            }
            flag++;
            System.out.println(i.getAnswer());
            //判断用户输入与正确答案是否相同，相同count++, grade+相应分数;
        }
        //更新分数和正确数量
        try {
            if(userService.queryUserByUserId(user.getCardId()).getIsJoin()==1){
                double last_grade = userService.getLastGrade(user.getCardId());
                System.out.println("last:" + last_grade);
                System.out.println("grade:" + grade);
                if (last_grade < grade){
                    userService.update_count(user.getCardId(), count);
                    userService.update_grade(user.getCardId(), grade);
                    userService.update_time(user);
                }
            } else {
                userService.update_count(user.getCardId(), count);
                userService.update_grade(user.getCardId(), grade);
                userService.update_time(user);
            }
            userService.update_join(user);
            msg.setCode("200");
            msg.setMsg(""+grade);
        } catch (Exception e){
            e.printStackTrace();
            msg.setCode("400");
            msg.setMsg("wrong");
        }
        return msg;
    }

}
