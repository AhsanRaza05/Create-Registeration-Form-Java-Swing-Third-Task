/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.daoimpl;

import com.test.dao.DepartmentDAO;
import com.test.dbconnection.DBConnection;
import com.test.model.Student;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.test.dao.StudentDAO;

/**
 *
 * @author Ahsan
 */
public class StudentDAOImp implements StudentDAO{

    static Connection con = DBConnection.getDBConnection();
    
    @Override
    public boolean addStudent(Student s) {
        
        Integer deptId = null;
        try {

            //PreparedStatement pst = con.prepareStatement("insert Into students(name,age,city,email,CNIC,address) values(?,?,?,?,?,?)");
          
            PreparedStatement pst = con.prepareStatement("insert into students(name, rollno, age, fees, gender, d_id, city, email, address) values(?,?,?,?,?,?,?,?,?)");
          
            System.out.println(s.getDepartment());
            
            deptId = new DepartmentDAOImp().getDepartmentId(s.getDepartment());
            
            pst.setString(1, s.getName());
            pst.setString(2, s.getRollNo());
            pst.setInt(3, s.getAge());
            pst.setInt(4, s.getFee());
            pst.setString(5, s.getGender());
            pst.setInt(6, deptId);
            pst.setString(7, s.getCity());
            pst.setString(8, s.getEmail());
            pst.setString(9, s.getAddress());
            
            int rowsAffected = pst.executeUpdate();
            
            return(rowsAffected >= 1);
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Sorry but Student can not be added!");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteStudent(Integer id) {
        
        try {
            
            PreparedStatement pst = con.prepareStatement("delete from students where id = ?" );
            
            pst.setInt(1, id);
           
            int rowsAffected = pst.executeUpdate();
            
            return(rowsAffected >= 1);
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Sorry but Student can not be deleted!");
        }

        return false;
    }

    @Override
    public boolean updateStudent(Student s) {
        
        Integer deptId = null;
        try {

            PreparedStatement pst = con.prepareStatement("update students set name = ?, rollno = ?, age = ?, fees = ?, gender = ?, d_id = ?, city = ?, email = ?, address = ? where id = ?");

            System.out.println(s.getDepartment());
            deptId = new DepartmentDAOImp().getDepartmentId(s.getDepartment());

            pst.setInt(10, s.getId());

            pst.setString(1, s.getName());
            pst.setString(2, s.getRollNo());
            pst.setInt(3, s.getAge());
            pst.setInt(4, s.getFee());
            pst.setString(5, s.getGender());
            pst.setInt(6, deptId);
            pst.setString(7, s.getCity());
            pst.setString(8, s.getEmail());
            pst.setString(9, s.getAddress());

            int rowsAffected = pst.executeUpdate();

            return (rowsAffected >= 1);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Sorry but Student can not be Updated!");
        }
        
        return false;
    }
    
    @Override
    public List getAllStudent() {
        
        List  <Student>studentsList = new ArrayList(0);
        
        String deptName = "";
        
        try {
            
            PreparedStatement pst = con.prepareStatement("select * from students" );
            
            ResultSet rs = pst.executeQuery();
            
            studentsList = new ArrayList(5);
            
            while(rs.next()){
                deptName = new DepartmentDAOImp().getDepartmentName(rs.getInt(7));
                // String name, String rollNo, String email, String gender, String department, String city, String address, Integer age, Integer fee)
                studentsList.add(new Student(rs.getString(2), rs.getString(3), rs.getString(9), rs.getString(6),deptName, rs.getString(8),rs.getString(10), rs.getInt(4), rs.getInt(5),rs.getInt(1)));
            }
            
            return studentsList;
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Sorry but could not fetch All students!");
        }

        return studentsList;
    }
    
    @Override
    public Student getSpecificStudent() {
       
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List getAllCities() {
        
        List <String> list = new ArrayList();
        
        try {
            
            list = new ArrayList(5);
            PreparedStatement pst = con.prepareStatement("select distinct city from students " );
            
            ResultSet rs = pst.executeQuery();
           
            while(rs.next()){
                
                list.add(rs.getString(1));
            }
            return(list);
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Sorry but could not find cities!");
           // e.printStackTrace();
        }
        
        return(list);
    }

}
