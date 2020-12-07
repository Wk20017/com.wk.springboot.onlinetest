package com.wk.springboot.vo;

public class Answer {
    private Integer test_id;
    private String answer;

    public Integer getAnswer_id() {
        return test_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.test_id = answer_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
