package ru.intf.model;

import javax.ejb.Local;

@Local
public interface FacadeFullLocal {
    void myRemove();
    String info();
}