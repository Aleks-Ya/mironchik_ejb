package ru.intf.model;

import javax.ejb.Remote;

@Remote
public interface FacadeRemote {
    String info();
}