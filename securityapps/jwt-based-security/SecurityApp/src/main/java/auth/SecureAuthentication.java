/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

//import beans.LoginBean;
import io.jsonwebtoken.ExpiredJwtException;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.CredentialValidationResult.Status;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jwtrest.Constants.AUTHORIZATION_HEADER;
import static jwtrest.Constants.BEARER;
import jwtrest.JWTCredential;
import jwtrest.TokenProvider;
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
 @Inject TokenProvider tokenProvider;
 @Inject KeepRecord keepRecord;
// HttpSession session;
    
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext ctx) throws AuthenticationException {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
      String token = extractToken(ctx);
      try{
       //   session = request.getSession();
        if(request.getRequestURI().contains("logout"))
    {
        
            request.logout();
            keepRecord.reset();
        
            
           // request.getRequestDispatcher("/index.jsp").forward(request, response);              
            
           response.sendRedirect("index.jsp");
            return ctx.doNothing();
       
        
    }
        
      if(request.getParameter("username")!=null)
      {
          String username = request.getParameter("username");
          String password = request.getParameter("password");
//          String username = lbean.getUsername();
//          String password = lbean.getPassword();
          Credential credential = new UsernamePasswordCredential(username, new Password(password));
          result = handler.validate(credential);
          if(result.getStatus()== Status.VALID)
          {
              AuthenticationStatus status = createToken(result, ctx);
             
              status = ctx.notifyContainerAboutLogin(result);
             keepRecord.setUsername(username);
             keepRecord.setPassword(password);
              keepRecord.setPrincipal(result.getCallerPrincipal());
              keepRecord.setRoles(result.getCallerGroups());
        if(request.getRequestURI().contains("index.jsp"))
              {
                  request.setAttribute("user", result.getCallerPrincipal().getName());
                  if(result.getCallerGroups().contains("Admin"))
                          {
                              
                              request.getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
                          return status;
                          }
                  else if(result.getCallerGroups().contains("Supervisor"))
                          {
                              
                              request.getServletContext().getRequestDispatcher("/users.jsp").forward(request, response);
                          return status;
                          }
                  
                  
              }
              
          }
          else
          {
              request.setAttribute("error", "User Name and Password do not match with our records ..");
              request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
              return ctx.doNothing();
          }
      }
     if(keepRecord.getToken()!=null)
     {
//          Credential credential1 = new UsernamePasswordCredential(KeepRecord.getUsername(), new Password(KeepRecord.getPassword()));
//          result = handler.validate(credential1);
//          AuthenticationStatus status = createToken(result, ctx);
          ctx.notifyContainerAboutLogin(keepRecord.getPrincipal(), keepRecord.getRoles());
     }
      
      }
    catch(Exception e)
    {
        e.printStackTrace();
    }
      
     if (token != null) {
            // validation of the jwt credential

            return validateToken(token, ctx);
//        } else if (ctx.isProtected()) {
//            // A protected resource is a resource for which a constraint has been defined.
//            // if there are no credentials and the resource is protected, we response with unauthorized status
//            return ctx.responseUnauthorized();
        }
      return ctx.doNothing();
    }
    
    private AuthenticationStatus validateToken(String token, HttpMessageContext context) {
        try {
            if (tokenProvider.validateToken(token)) {
                JWTCredential credential = tokenProvider.getCredential(token);
               // System.out.println("JWTAuthenticationMechanism-Token Validated");
                return context.notifyContainerAboutLogin(credential.getPrincipal(), credential.getAuthorities());

            }
            // if token invalid, response with unauthorized status
            return context.responseUnauthorized();
        } catch (ExpiredJwtException eje) {
            //LOGGER.log(Level.INFO, "Security exception for user {0} - {1}", new String[]{eje.getClaims().getSubject(), eje.getMessage()});
            return context.responseUnauthorized();
        }
    }

    /**
     * Create the JWT using CredentialValidationResult received from
     * IdentityStoreHandler
     *
     * @param result the result from validation of UsernamePasswordCredential
     * @param context
     * @return the AuthenticationStatus to notify the container
     */
    private AuthenticationStatus createToken(CredentialValidationResult result, HttpMessageContext context) {
        if (!isRememberMe(context)) {
            // if (true) {
             String jwt = tokenProvider.createToken(result.getCallerPrincipal().getName(), result.getCallerGroups(), false);
            //context.getRequest().getSession().setAttribute("token", jwt);
            keepRecord.setToken(jwt);
            context.getResponse().addHeader(AUTHORIZATION_HEADER, BEARER + jwt);
            System.out.println("Token Value"+ jwt);
        
           
        }
        System.out.println("JWTAuthenticationMechanism - Token Created");
        
        return context.notifyContainerAboutLogin(result.getCallerPrincipal(), result.getCallerGroups());
    }

    /**
     * To extract the JWT from Authorization HTTP header
     *
     * @param context
     * @return The JWT access tokens
     */
    private String extractToken(HttpMessageContext context) {
        String authorizationHeader = context.getRequest().getHeader(AUTHORIZATION_HEADER);
        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER)) {
            String token = authorizationHeader.substring(BEARER.length(), authorizationHeader.length());
          //  System.out.println("JWTAuthenticationMechanism - Extract Tokens");
            return token;
        }
        return null;
    }

    /**
     * this function invoked using RememberMe.isRememberMeExpression EL
     * expression
     *
     * @param context
     * @return The remember me flag
     */
    public Boolean isRememberMe(HttpMessageContext context) {
        return Boolean.valueOf(context.getRequest().getParameter("rememberme"));
    }
}
