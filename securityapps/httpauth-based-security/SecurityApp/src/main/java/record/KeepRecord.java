/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package record;

import java.io.Serializable;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.security.enterprise.CallerPrincipal;

/**
 *
 * @author root
 */
@Named
@SessionScoped
public class KeepRecord implements Serializable {
    
    CallerPrincipal principal;
    Set<String> roles;

    public KeepRecord() {
    }

    public  CallerPrincipal getPrincipal() {
        return principal;
    }

    public  void setPrincipal(CallerPrincipal principal) {
        this.principal = principal;
    }

    public  Set<String> getRoles() {
        return roles;
    }

    public  void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    
    public  void reset()
    {
        principal=null;
        roles=null;
    }
    
    
}
