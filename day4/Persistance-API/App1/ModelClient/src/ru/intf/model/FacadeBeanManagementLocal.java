package ru.intf.model;

import javax.ejb.Local;

@Local
public interface FacadeBeanManagementLocal {
    String info();
}