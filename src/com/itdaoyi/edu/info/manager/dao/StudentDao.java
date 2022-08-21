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

    public void deleteStudentById(String delId) {
        //查找索引
        int index = getIndex(delId);
        //使用null对该索引进行覆盖
        stu1[index]=null;
    }

    public int getIndex(String delId) {
        int index = -1;
        for (int i = 0; i < stu1.length; i++) {
            Student stu = stu1[i];
            if (stu != null && stu.getSid().equals(delId)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void reviseStudentById(Student stu) {
        int index =getIndex(stu.getSid());
        stu1[index]=stu;

    }
}
