package com.atguigu.team.service;

/**
 * @author wyl
 * @description 自定义错误类
 * @create 2022-04-07 23:45
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -3387516993948L;
    public TeamException(){

    }
    public TeamException(String msg){
        super(msg);

    }


}
