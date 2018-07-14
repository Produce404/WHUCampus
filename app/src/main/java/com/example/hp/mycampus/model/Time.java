package com.example.hp.mycampus.model;

import java.io.Serializable;

public class Time implements Serializable {
    private String name;// 考试名
    private String date;// 日期

    // 构造函数
    public Time(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getDate() { return date; }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
