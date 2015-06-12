/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.edu.npu.mis;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author STP
 */
public class Subject {
    List<Observer> observer = new ArrayList<>();
    /**
     *  o add observer ArrayList
     */
    public void attach(Observer o)
    {
        observer.add(o);
    }
    /**
     *  o remove observer ArrayList
     */
    public void detach(Observer o)
    {
        observer.remove(o);
    }
    /**
     *  run upDate
     */
    public void notifyObserver(String data)
    {
       for(Observer o :observer)
        {
           o.upDate(data);
        }
     
     }  
 }
