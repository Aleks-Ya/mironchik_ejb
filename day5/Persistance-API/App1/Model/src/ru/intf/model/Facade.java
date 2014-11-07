package ru.intf.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless(name = "SessionEJB")
public class Facade implements FacadeLocal {
    @PersistenceContext(unitName = "ModelXA")
    private EntityManager em;

    @Override
    public List<Report> getReports(int id) {
        return em.createNativeQuery("SELECT dname, ename, job, sal FROM emp, dept " +
                "WHERE emp.deptno = dept.deptno AND dept.deptno=?", Report.class)
                .setParameter(1, id)
                .getResultList();
    }
}