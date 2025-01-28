/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generics;

import java.util.List;

/**
 *
 * @author root
 */
public class GenericFunc {
    // Simple
    public  <E> void print(E e)
    {
        System.out.println(e);
    }
    
    // Wild cards
    
    public Double add(List<? extends Number> l)
    {
        double sum =0.0;
        
        for(Number x : l)
        {
            sum += x.doubleValue();
        }
    return sum;
    }
    
    public  void display(List<?> li)
    {
        for(Object o: li)
        {
            System.out.println(o);
        }
    }



}



