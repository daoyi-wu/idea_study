package com.itdaoyi.edu.info.manager.dao;

import com.itdaoyi.edu.info.manager.domain.Student;

public class StudentDao {
     private static Student[] stu1 = new Student[5];
    public  Boolean addStudent(Student stu) {
        //数组存储对象
        int index = -1;
        for (int i = 0; i < stu1.length; i++) {
            if(stu1[i]==null){
                index = i;
                break;
            }
        }
        if (index==-1){
            return false;
        }else {
            stu1[index] = stu;
            return true;
        }
    }

    public Student[] findAllStudent() {
        return stu1;
    }
}
