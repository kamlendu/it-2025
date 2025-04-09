/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import beans.HelloBean;
import beans.LoginBean;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.CredentialValidationResult.Status;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import record.KeepRecord;

/**
 *
 * @author root
 */
@Named
@RequestScoped
public class SecureAuthentication implements HttpAuthenticationMechanism, Serializable {
@Inject IdentityStoreHandler handler;
CredentialValidationResult result;
AuthenticationStatus status;
 @Inject LoginBean lbean;
 @Inject KeepRecord keepRecord;
 
 
    
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext ctx) throws AuthenticationException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  String username=""; String password="";
      try{
        
        
      if(lbean.getUsername()!=null || request.getParameter("username")!=null)
      {
          if(lbean.getUsername()!=null)
          {
               username = lbean.getUsername();
              password = lbean.getPassword();
          }
          else if (request.getParameter("username")!=null){
           username = request.getParameter("username");
          
          password = request.getParameter("password");
          }
          System.out.println("In Auth");
          
          AuthenticationStatus status = lbean.getStatus();
          SecurityContext sctx = lbean.getCtx();
          Credential credential;
          credential = new UsernamePasswordCredential(username, new Password(password));
          
          result = handler.validate(credential);
         
          if(result.getStatus()== Status.VALID)
          {
             
             
              status = ctx.notifyContainerAboutLogin(result);
              keepRecord.setUsername(username);
              keepRecord.setPassword(password);
              keepRecord.setPrincipal(result.getCallerPrincipal());
              keepRecord.setRoles(result.getCallerGroups());
        
              
              lbean.setStatus(status);
              lbean.setRoles(result.getCallerGroups());
              return status;
        
        }
          else
          {
              lbean.setErrorStatus("User or Password is not correct !");
              lbean.setStatus(AuthenticationStatus.SEND_FAILURE);
             // request.getServletContext().getRequestDispatcher("/Login.jsf").forward(request, response);
          }
      }
     if(keepRecord.getPrincipal()!=null)
     {
          Credential credential1 = new UsernamePasswordCredential(keepRecord.getUsername(), new Password(keepRecord.getPassword()));
          result = handler.validate(credential1);
         
          ctx.notifyContainerAboutLogin(keepRecord.getPrincipal(), keepRecord.getRoles());
     }
      
      }
    catch(Exception e)
    {
        e.printStackTrace();
    }
      
    
      return ctx.doNothing();
    }
    
}
    
