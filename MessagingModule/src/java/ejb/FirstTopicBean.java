/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package ejb;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author root
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/ittopic1"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/ittopic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/ittopic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class FirstTopicBean implements MessageListener {
    
    public FirstTopicBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        String msg =null;
    if(message instanceof TextMessage)
    {
            try {
                
                msg =  ((TextMessage) message).getText();
                
                System.out.println("FirstTopicBean has recieved the message " + msg);
                
                
                
                
                
                
                
            } catch (JMSException ex) {
                Logger.getLogger(FirstQueueBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try{
                
                Properties p = new Properties();
                p.setProperty(Context.PROVIDER_URL, "mq://localhost:7676");
          
                // Queue Message 
             InitialContext ic = new InitialContext(p);
             
             Queue queue = (Queue) ic.lookup("jms/mware");
             ConnectionFactory cf = (ConnectionFactory) ic.lookup("jms/mwareFactory");
             Connection con =  cf.createConnection();
             Session session = con.createSession();
             MessageProducer mp = session.createProducer(queue);
             TextMessage tm = session.createTextMessage();
             tm.setText("First Topic Bean sends the message to mware and the message was "+ msg);
             
             mp.send(tm);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }
    }
    
}
