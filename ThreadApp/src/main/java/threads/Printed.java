/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

/**
 *
 * @author root
 */
public class Printed {
    
     synchronized public void print()
  {
      int y=0;
       for(int i=0; i<6 ; i++)
    {
       // x++;
        y++;
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
//        }
       // y++;
        System.out.println(" The "+ Thread.currentThread().getName() + " thread is running y= "+y);
    }
  }
    
}
