/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.genericapp;

import generics.GenericFunc;
import generics.MyGenericClass;
import java.util.Date;

/**
 *
 * @author root
 */
public class GenericApp {

    public static void main(String[] args) {
     
        GenericFunc func = new GenericFunc();
        func.print(39.55);
        func.print(55);
        func.print("Hello");
        func.print(new Date());
        
        MyGenericClass<Integer> mgint = new MyGenericClass();
//        MyGenericClass<String> mgstr = new MyGenericClass();
//        
        mgint.add(10);
        mgint.add((20));
        mgint.add(30);
        
        System.out.println("Sum = "+func.add(mgint.getLi()));
        func.display(mgint.getLi());
//        
//        mgstr.add("priya");
//        mgstr.add("paresh");
//        
//        mgint.printList();
//        mgstr.printList();
//        
        System.out.println("Hello World!");
    }
}
