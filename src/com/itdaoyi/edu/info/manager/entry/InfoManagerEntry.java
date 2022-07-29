package com.itdaoyi.edu.info.manager.entry;

import java.util.Scanner;

public class InfoManagerEntry {
    public static void main(String[] args) {
        //主方法入口
        Scanner getkb = new Scanner(System.in);
        while (true){
            System.out.println("-----------------欢迎来到道一信息管理系统-----------------");
            System.out.println("1.学生管理\b2.教师管理\b3.退出系统\n请输入您的选择：");
            String cs = getkb.next();
            switch (cs){
                case "1":
                    System.out.println("学生管理");
                    break;
                case "2" :
                    System.out.println("教师系统");
                    break;
                case "3":
                    System.out.println("感谢您的使用^_^");
                    System.exit(0);
                default:
                    System.out.println("您输入有误，请您重新输入！");
                    break;
            }
        }

    }
}
