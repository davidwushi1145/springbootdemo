package com.example.demo.Dao;

import com.example.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IStudentDao extends JpaRepository<Student,Long> {
    Student findStudentByNameAndPassword(String name,String password);//模板语法
    Student findStudentById(Long id);
    @Transactional
    @Modifying
    @Query("update Student s set s.name=?1 where s.id=?2")
    int UpdateStudentNameById(String name,Long id);
}

