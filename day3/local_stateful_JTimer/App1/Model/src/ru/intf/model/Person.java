package ru.intf.model;

import java.io.Serializable;

public class Person implements Serializable {
    private String fn;
    private String sn;
    private String info;

    public Person(String fn, String sn, String info) {
        this.fn = fn;
        this.sn = sn;
        this.info = info;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}