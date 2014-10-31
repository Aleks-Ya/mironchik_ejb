package ru.intf.model;

import javax.ejb.Local;

@Local
public interface FacadeContainerManagementLocal {
    void execSQL(String sql) throws Exception;

}