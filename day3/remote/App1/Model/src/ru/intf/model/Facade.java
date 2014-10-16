package ru.intf.model;

import javax.ejb.Stateless;

@Stateless(mappedName = "F1")
public class Facade implements FacadeRemote, FacadeLocal {
    private long id;

    public Facade() {
        id = System.currentTimeMillis();
        System.out.println("======Constructor : bean id=" + id + " created.");
    }

    @Override
    public String info() {
        System.out.println("=====Method info() id=" + id);
        return "Привет, Мир! id=" + id;
    }
}