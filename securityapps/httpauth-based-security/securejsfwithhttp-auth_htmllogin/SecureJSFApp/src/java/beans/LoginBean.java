/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import record.KeepRecord;


/**
 *
 * @author root
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    @Inject KeepRecord keepRecord;
    
    private String errorstatus;// = keepRecord.getErrorStatus();
    
    public String getErrorStatus() {
        return keepRecord.getErrorStatus();
    }

    public void setErrorStatus(String status) {
        //status = KeepRecord.getErrorStatus();
        this.errorstatus = status;
    }

 
    public LoginBean() {
        
       // errorstatus="";
    }
    
   
    
  
}
