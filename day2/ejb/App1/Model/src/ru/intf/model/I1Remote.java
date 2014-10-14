package ru.intf.model;

import javax.ejb.Remote;

@Remote
public interface I1Remote {
    String info();
}