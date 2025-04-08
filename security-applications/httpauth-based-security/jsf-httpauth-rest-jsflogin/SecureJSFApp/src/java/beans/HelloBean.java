/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.SecureClient;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import record.KeepRecord;

/**
 *
 * @author root
 */
@Named(value = "helloBean")
@RequestScoped
public class HelloBean {
    @Inject KeepRecord keepRecord;
    SecureClient cl;
    String secureHello;
    String message="";
    String uname;
    String pname;

    public KeepRecord getKeepRecord() {
        return keepRecord;
    }

    public void setKeepRecord(KeepRecord keepRecord) {
        this.keepRecord = keepRecord;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    
    public String getMessage() {
        return message;
       
    }

    /**
     * Creates a new instance of HelloBean
     */
    public void setMessage(String message) {    
        this.message = message;
    }

    public HelloBean() {
    }

    public String getSecureHello() {
        try{
          uname = keepRecord.getUsername();
          pname = keepRecord.getPassword();
         cl = new SecureClient(uname,pname );
         message="";
        return cl.sayHello();
        }
        catch(Exception e)
        {
            message="You are Forbidden to access";
        }
        return null;
     }

    public void setSecureHello(String secureHello) {
        this.secureHello = secureHello;
    }
    
}
