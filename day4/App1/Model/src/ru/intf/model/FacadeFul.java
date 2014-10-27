package ru.intf.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import java.util.concurrent.TimeUnit;

@Stateful
@StatefulTimeout(value = 5, unit = TimeUnit.MINUTES)
public class FacadeFul implements FacadeFulLocal {
    private long id;
    private int counter;

    @Override
    @Remove
    public void myRemove() {
        System.out.println("------------ REMOVE " + id);
    }

    @Override
    public String info() {
        counter++;
        System.out.println("------------ INFO " + id);
        return "Привет, id=" + id + ", counter=" + counter;
    }

    @PostConstruct
    public void init() {
        id = System.currentTimeMillis();
        System.out.println("------------ POST CONSTRUCT " + id);
    }

    @PostActivate
    public void activate() {
        System.out.println("------------ POST ACTIVATE " + id);
    }

    @PrePassivate
    public void passivate() {
        System.out.println("------------ PRE PASSIVATE " + id);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("------------ PRE DESTROY " + id);
    }
}