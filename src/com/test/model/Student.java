/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.model;

/**
 *
 * @author Ahsan
 */
public class Student {
    private String name;
    private String rollNo, email;
    private String gender;
    private String department;
    private String city;
    private String address;
    
    private Integer age; 
    private Integer fee;
    private Integer id;
    
    public Student(){
        
    }
    
    public Student(String name, String rollNo, String email, String gender, String department, String city, String address, Integer age, Integer fee, Integer id) {
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.city = city;
        this.address = address;
        this.age = age;
        this.fee = fee;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
