package ru.intf.model;

import javax.ejb.Local;

@Local
public interface FacadeFulLocal {
    String info();

    void myRemove();
}