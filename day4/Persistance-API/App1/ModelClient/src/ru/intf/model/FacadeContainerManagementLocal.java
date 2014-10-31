package ru.intf.model;

import javax.ejb.Local;

@Local
public interface FacadeContainerManagementLocal {
    void execSQL(String sql) throws Exception;

    /**
     * Возвращает информацию о таблицах БД.
     */
    Object[] getUserTables();
}