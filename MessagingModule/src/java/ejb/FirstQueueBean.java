/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/MessageDrivenBean.java to edit this template
 */
package ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author root
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/itqueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class FirstQueueBean implements MessageListener {
    
    public FirstQueueBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        String msg = null;
    if(message instanceof TextMessage)
    {
            try {
                
                msg =  ((TextMessage) message).getText();
                
                System.out.println("FirstQueueBean has recieved the message " + msg);
                
            } catch (JMSException ex) {
                Logger.getLogger(FirstQueueBean.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
    }
    
}
