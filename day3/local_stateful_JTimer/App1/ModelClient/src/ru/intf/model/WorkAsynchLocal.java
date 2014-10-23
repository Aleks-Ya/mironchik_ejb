package ru.intf.model;

import javax.ejb.Local;
import java.util.concurrent.Future;

@Local
public interface WorkAsynchLocal {
    void info1();

    Future infoWithFuture();
}