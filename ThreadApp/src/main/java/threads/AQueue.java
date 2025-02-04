/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

/**
 *
 * @author root
 */
public class AQueue {
    
    int n;
    boolean vset=false;
  
    synchronized public int get()
    {
        while(!vset)
        {
            try{
            wait();
            }
            catch(InterruptedException ie)
            {
                System.out.println("InterruptedException caught");
            }
        }
        System.out.println("Got: " + n);
        vset=false;
        notify();
        return n;
    }
    
     synchronized public void put(int n)
    {
        while(vset)
        {
             try{
            wait();
            }
            catch(InterruptedException ie)
            {
                System.out.println("InterruptedException caught");
            }
            
        }
        this.n=n;
        vset = true;
        System.out.println("Put: " + n);
        notify();
    }
    
    
}
