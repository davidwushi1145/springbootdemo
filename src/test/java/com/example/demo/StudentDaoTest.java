package com.example.demo;

import com.example.demo.Dao.IStudentDao;
import com.example.demo.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentDaoTest {
    @Autowired
    private IStudentDao sDao;
    @Test
    public void insertStudent() {
        Student s = new Student();
        s.setName("张三");
        s.setAge(18);
        s.setSex(true);
        s.setPassword("123456");
        sDao.save(s);
    }
    @Test
    public void Login() {
        Student s = sDao.findStudentByNameAndPassword("张三","123456");
        System.out.println(s);
    }
    @Test
    public void UpdateStudentNameById() {
        int i = sDao.UpdateStudentNameById("李四",1L);
        System.out.println(i);
    }
}
