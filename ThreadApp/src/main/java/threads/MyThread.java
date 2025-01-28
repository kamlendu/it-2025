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
public class MyThread extends Thread {

    String id;
    int x=0;

    public MyThread(String id) {
        this.id = id;
    }
    
    @Override
    public void run() {
       // super.run(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
   print();
    }
    
   void print()
  {
       for(int i=0; i<6 ; i++)
    {
        x++;
        //try {
            //this.sleep(1000);
       // } catch (InterruptedException ex) {
        //    Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        //}
        System.out.println(x + " The "+ Thread.currentThread().getName() + " thread is running");
    }
  }
}
