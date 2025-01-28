/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class MyGenericClass<T> {
    T obj;
    List<T> li = new ArrayList<>();

    public List<T> getLi() {
        return li;
    }
    
    public void add(T t)
    {
        li.add(t);
    }
    
   public void printList()
    {
        for(T t: li)
        {
            System.out.println(t);
        }
    }
    
}
