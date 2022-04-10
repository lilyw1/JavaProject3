package com.atguigu.team.domain;

/**
 * @author wyl
 * @description 设计师类，继承程序员
 * @create 2022-04-07 22:43
 */
public class Designer extends Programmer {
    private double bonus;//奖金

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDescription();
    }

    public String getDetailsForTeam() {
        return getBaseDetails() + "\t设计师\t" + getBonus();

    }
}
