/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

/**
 *
 * @author root
 */


public class MyThread implements Runnable {
Printed p;
    String id;
    int x=0;

    public MyThread(String id, Printed p) {
        this.id = id;
        this.p=p;
       
    }
    
    @Override
    public void run() {
        p.print();
        //print();
    }
    
  
   synchronized public void print()
  {
      int y=0;
       for(int i=0; i<6 ; i++)
    {
       
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
