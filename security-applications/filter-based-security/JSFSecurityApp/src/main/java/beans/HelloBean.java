/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.SecureClient;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import record.KeepRecord;
//import record.KeepRecord;

/**
 *
 * @author root
 */
@Named(value = "helloBean")
@RequestScoped
public class HelloBean {
   @Inject private KeepRecord keepRecord;
    
    SecureClient cl;
    String secureHello;
    String message="";

    
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
              HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
      
          //    HttpServletRequest hrequest = (HttpServletRequest)  FacesContext.getCurrentInstance().getExternalContext().getRequest();
// String username= (String) request.getSession().getAttribute("username");
//  String password=  (String)  request.getSession().getAttribute("password");
//        // hrequest.getSession().setAttribute("password", password);

              HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
      //String username = request.getSession().getAttribute("username").toString();
        //String password = request.getSession().getAttribute("password").toString();
   
        HttpSession session = request.getSession(false);
if (session != null) {
    String sessionId = session.getId();

//   CloseableHttpClient client = HttpClientBuilder.create().build();
//    HttpGet httpGet = new HttpGet("http://localhost:8080/JSFSecurityApp/webresources/secure");
//    httpGet.setHeader("Cookie", "JSESSIONID=" + sessionId);
//
//    CloseableHttpResponse response1 = client.execute(httpGet);
    // handle response
}

        
         String username = keepRecord.getUsername();
       String password = keepRecord.getPassword();
       
        cl = new SecureClient(request.getSession().getId());
         message="";
        return cl.sayHello();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            message="You are Forbidden to access";
        }
        return null;
     }

    public void setSecureHello(String secureHello) {
        this.secureHello = secureHello;
    }
  
}
