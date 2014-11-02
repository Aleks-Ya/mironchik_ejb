package ru.intf.model;

import ru.intf.model.orm.Person;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Транзакциями управляет контейнер.
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)//По-умолчанию
public class FacadeContainerManagement implements FacadeContainerManagementLocal {
    @PersistenceContext(unitName = "ModelDDL")
    private EntityManager emDDL;

    @PersistenceContext(unitName = "ModelXA")
    private EntityManager emXA;

    @Override
    public void execSQL(String sql) throws Exception {
        int c = emDDL.createNativeQuery(sql).executeUpdate();
        System.out.println("Обработано " + c);
    }

    @Override
    public Object[] getUserTables() {
        return emXA.createNativeQuery("SELECT * FROM pg_catalog.pg_tables").getResultList().toArray();
    }

    @Override
    public List<Person> getPersons() {
        return emXA.createNativeQuery("SELECT ename, job, sel, empno FROM emp", Person.class).getResultList();
    }
}