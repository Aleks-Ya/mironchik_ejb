package ru.intf.model;

import javax.ejb.Local;

@Local
public interface FacadeLocal {
    void startJob();

    void stopJob();

    String testAsynch();

    String testAsynchWithFuture();
}