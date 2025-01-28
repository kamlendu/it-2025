/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;

/**
 *
 * @author root
 */

// All full qualified java classes are called beans
public class Employee implements Serializable {
    
    
    int empno;
    String ename;
    double salary;
   // Hashtable myerrors;
    HashMap<String,String> errors;

    public Employee() {
        this.empno=0;
        this.ename="";
        this.salary=0.0;
        errors = new HashMap<>();
    }

    
    public Employee(int empno, String ename, double salary) {
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
        errors = new HashMap<>();
    }

    
   public boolean validate()
    {
        boolean allOK=true;
        
        if(empno<=0){
            errors.put("empno", "The Employee No can not be zero or less");
            allOK= false;
        }
        if(ename.equals(""))
        {
            errors.put("ename", "Name can not be blank ");
            allOK=false;
        }
        if(salary<=0.0)
        {
            errors.put("salary", "Salary cant be zero or less ");
            allOK=false;
        }
       
        return allOK;
    }
    
    
    public String getError(String field)
    {
        String err = errors.get(field.trim());
        return (err==null)?"":err;
    }
    
    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
    
}
