package com.atguigu.team.service;

/**
 * @author wyl
 * @description 表示员工状态.枚举类---有限个对象
 * @create 2022-04-07 22:33
 */
public class Status {
    private final String NAME;

    private Status(String name){
        this.NAME = name;
    };

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
