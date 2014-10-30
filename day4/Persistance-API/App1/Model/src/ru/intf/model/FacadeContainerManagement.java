package ru.intf.model;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Транзакциями управляет контейнер.
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)//По-умолчанию
public class FacadeContainerManagement implements FacadeContainerManagementLocal {
    @PersistenceContext(unitName = "Model")
    private EntityManager em;

    @Override
    public void execSQL(String sql) throws Exception {
        int c = em.createNativeQuery(sql).executeUpdate();
        System.out.println("Обработано " + c);
    }
}