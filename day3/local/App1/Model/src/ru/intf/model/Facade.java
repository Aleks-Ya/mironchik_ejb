package ru.intf.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless(name = "F1EJB", mappedName = "F1")
public class Facade implements FacadeLocal {
    @Resource
    private SessionContext sess;
    @Resource(mappedName = "java:/jdbc/postgresql")
    private DataSource ds;
    private long id;

    public Facade() {
        id = System.currentTimeMillis();
        System.out.println("======Constructor : bean id=" + id + " ds=" + ds + " created.");
    }

    @Override
    public String info() {
        System.out.println("=====Method info() id=" + id + " ds=" + ds + " Session=" + sess);
        try {
            Thread.currentThread().sleep(3000);
        } catch (InterruptedException e) {

        }
        return "Привет, Мир! id=" + id + " ds=" + ds + " <br/>Session=" + sess;
    }

    @PostConstruct
    public void myInit() {
        System.out.println("======PostConstruct : bean id=" + id + " ds=" + ds);
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println("======PreDestroy : bean id=" + id);
    }
}