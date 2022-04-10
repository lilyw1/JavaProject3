package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;

/**
 * @author wyl
 * @description 关于开发团队成员的管理、添加和删除
 * @create 2022-04-08 23:21
 */
public class TeamService {
    private static int counter = 1;//给memberID赋值使用
    private final int  MAX_MEMBER = 5;//限制开发团队的人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员
    private int total;//记录开发团队实际人数

    public TeamService(){

    }
    //获取开发团队中的成员
    public Programmer[] getTeam(){
        Programmer[] team =new Programmer[total];
        for (int i = 0;i < team.length;i++){
            team[i] = this.team[i];
        }
        //不直接返回team,有可能没满.重新造个数组返回
        return team;
    }
    //将指定员工添加到开发团队中
    public void addMember(Employee e) throws TeamException {
        //成员已满，无法添加
        if(total >= MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        //不是开发成员，无法添加
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发成员，无法添加");
        }
        //已在本开发团队中
        if(isExit(e)){
            throw new TeamException("该成员已在本开发团队，无法添加");
        }
        //该员工已是某团队成员
        Programmer p = (Programmer) e;
        if("BUSY".equals(p.getStatus().getNAME())){
            throw new TeamException("该员工已是某团队成员，无法添加");
        }else if("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())){
            throw new TeamException("该员工正在休假，无法添加");
        }
        //该员工正在休假，无法添加



        //获取团队中架构师、设计师、程序员的人数
        int numOfArch = 0, numOfDes = 0,numOfPro = 0;
        for(int i = 0;i < total;i++){
            if(team[i] instanceof Architect){
                numOfArch++;
            }else if(team[i] instanceof Designer){
                numOfDes++;
            }else if(team[i] instanceof Programmer){
                numOfPro++;
            }
        }
        //团队中至多只能有一名架构师
        //团队中至多只能有两名设计师
        //团队中至多只能有三名程序员
        if(p instanceof Architect){
            if (numOfArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        }else if(p instanceof Designer){
            if (numOfDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if(p instanceof Programmer){
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        //将p(e)添加到team中（其实赋值的是地址值）
        team[total++] = p;
        //p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);



    }
    //判断指定员工是否存在于开发团队
    private boolean isExit(Employee e) {
        for(int i = 0; i < total;i++){
            if(team[i].getId() == e.getId()){
                return true;
            }
            //return team[i].getId() == e.getId();
        }
        return false;
    }

    //将指定员工从开发团队中删除
    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        //找到了break;找不到i == total
        for(;i < total;i++){
            if(team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if(i == total){
            throw new TeamException("找不到指定MemberId");
        }
        //后面的元素覆盖前面的元素
        for(int j = i + 1;j < total;j++){
            team[j - 1] = team[j];
        }
//        team[total - 1] = null;
//        total--;
        team[--total] = null;
    }
}
