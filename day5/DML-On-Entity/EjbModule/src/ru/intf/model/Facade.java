package ru.intf.model;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;
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
    private EntityManager em;

    @EJB
    private LogLocal logger;

    @Resource(mappedName = "java:/ConnectionFactory")
    private ConnectionFactory factory;

    @Resource(mappedName = "java:/queue/test")
    private Queue queue;

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

    @Override
    public void updateEmp(int empno, BigDecimal salary) {
        EmpEntity emp = getEmpById(empno);
        int newSal = salary.intValue();
        int oldSal = emp.getSal();
        emp.setSal(newSal);
        em.merge(emp);

//        logger.log(String.format("Зарплата изменена у id=%d с %d на %d.", empno, oldSal, newSal));

        Connection conn = null;
        Session ses = null;
        MessageProducer producer = null;
        try {
            conn = factory.createConnection();
            ses = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            producer = ses.createProducer(queue);

            TextMessage m = ses.createTextMessage();
            m.setText(String.format("Зарплата изменена у id=%d с %d на %d.", empno, oldSal, newSal));
            producer.send(m);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                producer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                ses.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}