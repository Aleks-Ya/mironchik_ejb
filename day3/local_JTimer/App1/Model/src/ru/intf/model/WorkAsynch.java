package ru.intf.model;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

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

    @Override
    @Asynchronous
    public Future infoWithFuture() {
        System.out.println("------- BEFORE ----------");
        Person p = new Person("11111", "22222", "33333");
        AsyncResult res = new AsyncResult(p);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("------- AFTER ----------");
        return res;
    }
}