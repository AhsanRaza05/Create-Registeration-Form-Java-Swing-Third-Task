/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.daoimpl;

import com.test.dao.DepartmentDAO;
import static com.test.daoimpl.StudentDAOImp.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahsan
 */
public class DepartmentDAOImp implements DepartmentDAO{
    
    @Override
    public Integer getDepartmentId(String deptName) {
     
        try {
            
            PreparedStatement pst = con.prepareStatement("select * from department where name = ? " );
            pst.setString(1, deptName);
           
            ResultSet rs = pst.executeQuery();
           
            return(rs.getInt(1));
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Sorry but could not find dept id!");
        }

        return -1;
    }

     @Override
    public String getDepartmentName(Integer id) {
       
        try {
            
            PreparedStatement pst = con.prepareStatement("select name from department where d_id = ? " );
            pst.setInt(1, id);
           
            ResultSet rs = pst.executeQuery();
           
            return(rs.getString(1));
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Sorry but could not find dept name!");
           // e.printStackTrace();
        }

        return "";
    }
    
    @Override
    public List getAlldepartments() {
        
        List <String> list = new ArrayList();
        
        try {
            
            list = new ArrayList(5);
            PreparedStatement pst = con.prepareStatement("select name from department" );
            
            ResultSet rs = pst.executeQuery();
           
            while(rs.next()){
                
                list.add(rs.getString(1));
            }
            return(list);
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Sorry but could not find departments!");
           // e.printStackTrace();
        }
        
        return(list);
    }
}
