/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

/**
 *
 * @author root
 */
public class MessageThread extends Thread{
    String message;
    MessagePrinter m;
    
   public MessageThread(MessagePrinter m, String message)
    {
        this.m=m;
        this.message=message;
    }

    @Override
    public void run() {
      //  super.run(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    //synchronized(m) {
      m.printMessage(message);
    //}
    
    }
    
   
    
}
