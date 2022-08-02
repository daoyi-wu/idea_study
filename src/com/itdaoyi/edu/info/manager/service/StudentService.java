package com.itdaoyi.edu.info.manager.service;

import com.itdaoyi.edu.info.manager.dao.StudentDao;
import com.itdaoyi.edu.info.manager.domain.Student;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public Boolean addStudent(Student stu) {
        return studentDao.addStudent(stu);
    }

    public boolean isExists(String stuid) {
        Student[] students = studentDao.findAllStudent();
        boolean exists = false;
        for (int i = 0; i < students.length; i++) {
           Student stu =  students[i];
           if(stu != null && stu.getSid().equals(stuid) ){
               exists = true;
               break;
           }
        }
        return exists;
    }
}
