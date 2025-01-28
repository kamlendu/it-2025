/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.threadapp;

import threads.MessagePrinter;
import threads.MessageThread;
import threads.MyThread;

/**
 *
 * @author root
 */
public class ThreadApp extends Thread {
    
      

    public static void main(String[] args) throws InterruptedException {
       
//        Thread t1 = new Thread(new MyThread("first"));
//        Thread t2 = new Thread(new MyThread("second"));
//       MyThread t1 = new MyThread("first");
//        MyThread t2 = new MyThread("second");
//         MyThread t3 = new MyThread("third");
//  // t1.setName("one");t2.setName("two");
  
  MessagePrinter mp = new MessagePrinter();
  MessageThread mt1 = new MessageThread(mp, "hello");
  MessageThread mt2 = new MessageThread(mp, "mydemo");
  MessageThread mt3 = new MessageThread(mp, "synchronous");
  
   System.out.println(Thread.currentThread().getName());
       
        mt1.start();
        mt2.start();
        mt3.start();
        
//        System.out.println(" t1 is alive "+ t1.isAlive());
//        System.out.println(" t2 is alive "+ t2.isAlive());
//        System.out.println(" t3 is alive "+ t3.isAlive());
//        
//        t1.join();
//        t2.join();
//        t3.join();
//       
//        System.out.println(" t1 is alive "+ t1.isAlive());
//        System.out.println(" t2 is alive "+ t2.isAlive());
//        System.out.println(" t3 is alive "+ t3.isAlive());
        
        
        
        System.out.println("Hello World!");
    }
}
