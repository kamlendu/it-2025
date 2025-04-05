/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.BookClient;
import ejb.BookBean;
import entity.BookMaster;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@Named(value = "employeeBean")
@Dependent
public class EmployeeBean {
    
    BookClient b;
    Response rs;
    Collection<Employee> employees;
    Collection<BookMaster> books;
    GenericType<Collection<BookMaster>> gbooks;
    
    String bookName;

    /**
     * Creates a new instance of EmployeeBean
     */
    public EmployeeBean() {
        
        b = new BookClient();
        books = new ArrayList<>();
        gbooks = new GenericType<Collection<BookMaster>>(){};
        
        employees = new ArrayList<>();
        Employee e1 = new Employee(1,"Suresh",23,"xxaxa", "surat", "42323", 3000);
        Employee e2 = new Employee(2,"Ramesh",24,"xxaxa", "surat", "42323", 3000);
        Employee e3 = new Employee(3,"Paresh",25,"xxaxa", "surat", "42323", 3000);
        Employee e4 = new Employee(4,"Rakesh",26,"xxaxa", "surat", "42323", 3000);
        Employee e5 = new Employee(5,"Sukesh",27,"xxaxa", "surat", "42323", 3000);
        employees.add(e1);employees.add(e2);employees.add(e3);employees.add(e4);employees.add(e5);
    }

    public Collection<BookMaster> getBooks() {
        rs = b.getBooks(Response.class);
        books = rs.readEntity(gbooks);
        return books;
    }

    public void setBooks(Collection<BookMaster> books) {
        this.books = books;
    }

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }

    
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    
    
    
}
