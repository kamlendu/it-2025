/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

/**
 *
 * @author root
 */
public class Consumer implements Runnable {
AQueue aq;


//    public Consumer(AQueue aq) {
//        this.aq=aq;
//        
//    }
 public Consumer(AQueue aq) {
        this.aq=aq;
        
    }
   
    
    
    @Override
    public void run() {
     int  n=0;
    while(n<50)
    {
        aq.get();
    }
    
    }
    
    
    
}
