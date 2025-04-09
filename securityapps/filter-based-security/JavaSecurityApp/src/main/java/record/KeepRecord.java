/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package record;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.security.enterprise.credential.Credential;

/**
 *
 * @author root
 */
@SessionScoped
public class KeepRecord implements Serializable {
    
     String username;
     String password;
     Credential credential;

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public KeepRecord() {
        
    }

    public  String getUsername() {
        return username;
    }

    public  void setUsername(String username) {
        this.username = username;
    }

    public  String getPassword() {
        return password;
    }

    public  void setPassword(String password) {
        this.password = password;
    }
    
    public  void reset()
    {
        username=null;
        password=null;
    }
    
    
    
}
