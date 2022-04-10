package com.atguigu.team.domain;

/**
 * @author wyl
 * @description 设备类型：电脑。电脑接口实现
 * @create 2022-04-07 22:13
 */
public class PC implements Equipment{
    private String model;//机器型号
    private String display;//显示屏尺寸

    public PC() {

    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model +"(" +display + ")";
    }
}
