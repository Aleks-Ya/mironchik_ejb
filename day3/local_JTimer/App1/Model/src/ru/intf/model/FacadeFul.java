package ru.intf.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Бин с состоянием.
 */
@Stateful
public class FacadeFul implements FacadeFullLocal {
    private long id;

    @Override
    @Remove
    public void myRemove() {
        System.out.println("------------ REMOVE " + id);
    }

    @Override
    public String info() {
        System.out.println("------------ INFO " + id);
        return "Привет, Stateful Bean";
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