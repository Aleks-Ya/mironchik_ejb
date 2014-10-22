package ru.intf.model;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless(name = "WorkAsynchEJB")
public class WorkAsynch implements WorkAsynchLocal {

    @Override
    @Asynchronous
    public void info1() {
        System.out.println("-----------------");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println("============= " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}