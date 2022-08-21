package com.itdaoyi.edu.info.manager.controller;

import com.itdaoyi.edu.info.manager.dao.StudentDao;
import com.itdaoyi.edu.info.manager.domain.Student;
import com.itdaoyi.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private Scanner getkb = new Scanner(System.in);
    private StudentService studentService = new StudentService();
    public void start() {

        studentWhile:
        while (true){
            System.out.println("-----------------欢迎来到学生信息管理系统-----------------");
            System.out.println("1.添加学生信息\t2.删除学生信息\t3.修改学生信息\t4.查看学生信息\t5.退出学生信息管理系统\n请输入您的选择：");
            String cs = getkb.next();
            switch (cs){
                case "1":
                    addStudent();
//                    System.out.println("添加学生信息");
                    break;
                case "2" :
                    deleteStudentById();
//                    System.out.println("删除学生信息");
                    break;
                case "3":
                    reviseStudentById();
                    System.out.println("修改学生信息");
                case "4" :
//                    System.out.println("查看学生信息");
                    findAllStudent();
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

    private void reviseStudentById() {
        //键盘获取id,判断是否存在
        String reId;
        System.out.println("请输入想要修改学生的ID号：");
        while (true){
            reId = getkb.next();
            Boolean exists = studentService.isExists(reId);
            if (!exists){
                System.out.println("输入学生不存在，请重新输入：");
            }else {
                break;
            }

        }
        //调用Service中的修改方法对学生信息进行修改
        System.out.println("请输入学生姓名：");
        String stuname = getkb.next();
        System.out.println("请输入学生年龄");
        int stuage = getkb.nextInt();
        System.out.println("请输入学生生日：");
        String stubirthday = getkb.next();
        Student stu = new Student(reId,stuname,stuage,stubirthday);
        studentService.reviseStudentById(stu);
        //提示修改信息成功
        System.out.println("修改学生信息成功！");
    }

    public void deleteStudentById() {
        System.out.println("请输入您要删除学生的ID");
        String delId;
        while (true){
            //首先键盘录入数据
            delId = getkb.next();
            //其次通过Service中isExists（）进行判断输入是否存在
            Boolean exists = studentService.isExists(delId);
            if (exists==true){
                break;
            }else {
                System.out.println("您输入的学生ID不存在，请重新输入：");
            }
        }
        //如果存在，调用业务员方法进行删除
        studentService.deleteStudentById(delId);
        System.out.println("删除学生成功！");

    }

    public void findAllStudent() {
        //Controller需要向Service要数组
        Student[] stus = studentService.findAllStudent();
        if(stus == null){
            System.out.println("查无信息，请添加后重试");
            return;
        }
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null){
                System.out.println(stu.getSid()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t\t"+stu.getBirthday());
            }
        }
    }

    public void addStudent() {
        //接受输入信息，封装为一个学生对象
        String stuid;
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
