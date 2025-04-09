/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@DeclareRoles({"Admin","Supervisor"})

//@RolesAllowed("Admin")
@Stateless
public class SecureBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

//@PermitAll    
//@DenyAll
//    
//@RolesAllowed({"Admin","Supervisor"})  

//@RolesAllowed("Admin")
public String sayHello()
{
    return "A Secure Hello from EJB ";
}

}
