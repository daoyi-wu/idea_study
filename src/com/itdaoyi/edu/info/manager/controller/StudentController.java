package com.itdaoyi.edu.info.manager.controller;

import com.itdaoyi.edu.info.manager.domain.Student;
import com.itdaoyi.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    Scanner getkb = new Scanner(System.in);
    public void start() {

        studentWhile:
        while (true){
            System.out.println("-----------------欢迎来到学生信息管理系统-----------------");
            System.out.println("1.添加学生信息\t2.删除学生信息\t3.修改学生信息\t4.查看学生信息\t5.退出学生信息管理系统\n请输入您的选择：");
            String cs = getkb.next();
            switch (cs){
                case "1":
                    addStudent();
                    System.out.println("添加学生信息");
                    break;
                case "2" :
                    System.out.println("删除学生信息");
                    break;
                case "3":
                    System.out.println("修改学生信息");
                case "4" :
                    System.out.println("查看学生信息");
                    break;
                case "5":
                    System.out.println("已退出学生信息管理系统，现在界面是首页。");
                    break studentWhile;
                default:
                    System.out.println("您输入有误，请您重新输入！");
                    break;
            }
        }
    }

    public void addStudent() {
        //接受输入信息，封装为一个学生对象
        String stuid;
        StudentService studentService = new StudentService();
        while (true){
            System.out.println("请输入学生ID：");
            stuid = getkb.next();
            boolean result = studentService.isExists(stuid);
            if(result){
                System.out.println("ID已经存在");;
            }else {
                break;
            }
        }

        System.out.println("请输入学生姓名：");
        String stuname = getkb.next();
        System.out.println("请输入学生年龄");
        int stuage = getkb.nextInt();
        System.out.println("请输入学生生日：");
        String stubirthday = getkb.next();
        Student stu = new Student(stuid,stuname,stuage,stubirthday);
        StudentService stu1 = new StudentService();
        boolean result = stu1.addStudent(stu);
        if(result){
            System.out.println("添加成功！");
        }else {
            System.out.println("添加失败！");
        }
    }
}
