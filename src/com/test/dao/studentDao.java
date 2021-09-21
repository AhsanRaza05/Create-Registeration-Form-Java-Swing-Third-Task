/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.dao;

import com.test.model.Student;
import java.util.List;

/**
 *
 * @author Ahsan
 */
public interface studentDao {
    
    boolean addStudent(Student s);
    
    boolean deleteStudent(Student s);
    
    boolean updateStudent(Student s);
    
    Integer getDepartmentId(String deptName);
    
    List getAllStudent();
    
    Student getSpecificStudent();
    
    List getAlldepartments();
    
    List getAllCities();
    
    String getDepartmentName(Integer id);
}
