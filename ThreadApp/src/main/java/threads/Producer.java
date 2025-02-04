/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

/**
 *
 * @author root
 */
public class Producer implements Runnable {
AQueue aq;



//    public Producer(AQueue aq) {
//        this.aq=aq;
//        
//    }

     public Producer(AQueue aq) {
        this.aq=aq;
        
    }

   
    
    
    @Override
    public void run() {
     int  n=0;
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    while(n<50)
    {
        aq.put(n++);
    }
    System.exit(0);
    }
    
    
    
}
