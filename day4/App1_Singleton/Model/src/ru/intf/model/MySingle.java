package ru.intf.model;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Date;

@Singleton
@Startup
public class MySingle implements MySingleLocal {
    private String info = "Привет, мир";

    @PostConstruct
    public void init() {
        System.out.println("-------- Singleton created --------");
    }

    @Override
    @Lock(value = LockType.READ)
    public String getInfo() {
        System.out.println("---- getInfo " + new Date());
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return info;
    }

    @Override
    @Lock(value = LockType.WRITE)
    public void setInfo(String info) {
        this.info = info;
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("---- setInfo " + new Date());
    }
}