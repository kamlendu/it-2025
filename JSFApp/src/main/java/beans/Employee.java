/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author root
 */
public class Employee implements Serializable {
    
    int emno;
    String ename;
    int age;
    String email;
    String city;
    String telephone;
    double salary;

    public Employee(int emno, String ename, int age, String email, String city, String telephone, double salary) {
        this.emno = emno;
        this.ename = ename;
        this.age = age;
        this.email = email;
        this.city = city;
        this.telephone = telephone;
        this.salary = salary;
    }

    
    
    public int getEmno() {
        return emno;
    }

    public void setEmno(int emno) {
        this.emno = emno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
    
}
