/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class MessagePrinter {
    
    synchronized public void printMessage(String message)
    {
        System.out.print("["+ message);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MessagePrinter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("]");
    }
    
     
    
}
