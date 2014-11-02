package ru.intf.model;

import ru.intf.model.orm.Person;

import javax.ejb.Local;
import java.util.List;

@Local
public interface FacadeContainerManagementLocal {
    void execSQL(String sql) throws Exception;

    /**
     * Возвращает информацию о таблицах БД.
     */
    Object[] getUserTables();

    List<Person> getPersons();
}