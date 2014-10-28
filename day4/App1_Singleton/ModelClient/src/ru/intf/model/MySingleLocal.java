package ru.intf.model;

import javax.ejb.Local;

@Local
public interface MySingleLocal {
    String getInfo();
    void setInfo(String info);
}