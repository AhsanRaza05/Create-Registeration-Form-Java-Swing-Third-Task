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
public interface StudentDAO {
    
    boolean addStudent(Student s);
    
    boolean deleteStudent(Integer id);
    
    boolean updateStudent(Student s);
    
    List getAllStudent();
    
    Student getSpecificStudent();
    
    List getAllCities();
}
