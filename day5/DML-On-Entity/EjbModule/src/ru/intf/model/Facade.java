package ru.intf.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

/**
 * Выводит сотрудников с зарплатой меньше заданной.
 */
@Stateless
public class Facade implements FacadeLocal {

    @PersistenceContext(unitName = "PostgreSQLxa")
    EntityManager em;

    @Override
    public List<DeptEntity> getDeptAll() {
        return em.createNamedQuery("dept.getAll", DeptEntity.class).getResultList();
    }

    @Override
    public List<DeptEntity> getDeptBySal(BigDecimal s) {
        List<DeptEntity> deps = em.createNamedQuery("dept.getBySal", DeptEntity.class)
                .setParameter("p", s.intValue())
                .getResultList();
        for (DeptEntity dep : deps) {
            dep.getEmpsByDeptno().size();
        }
        return deps;
    }

    @Override
    public EmpEntity getEmpById(int id) {
        return em.find(EmpEntity.class, id);
    }
}