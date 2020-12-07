package com.wk.springboot.vo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

//import javax.validation.constraints.NotBlank;

public class User {
//    @NotBlank(message = "校园卡号不能为空！")
    private String card_id;
//    @NotBlank(message = "姓名不能为空！")
    private String user_name;
    private Integer company_id;
//    @NotBlank(message = "单位名称不能为空！")
    private String company_name;
    private Integer is_join;
    private double grade;
    private Integer right_count;
    private Integer time;

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getName() {
        return user_name;
    }

    public void setName(String name) {
        this.user_name = name;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public Integer getIs_join() {
        return is_join;
    }

    public void setIs_join(Integer is_join) {
        this.is_join = is_join;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Integer getRight_count() {
        return right_count;
    }

    public void setRight_count(Integer right_count) {
        this.right_count = right_count;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
