package ru.intf.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class Facade implements FacadeLocal {

    @PersistenceContext(unitName = "PostgreSQLxa")
    EntityManager em;

    @Override
    public List<DeptEntity> getDeptAll() {
//        return em.createQuery("SELECT deptno, dname, empsByDeptno FROM DeptEntity").getResultList();
        return em.createNamedQuery("dept.getAll").getResultList();
    }
}