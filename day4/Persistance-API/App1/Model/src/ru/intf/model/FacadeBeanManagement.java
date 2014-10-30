package ru.intf.model;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Транзакциями управляет сам бин.
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FacadeBeanManagement implements FacadeBeanManagementLocal {
    @PersistenceContext(unitName = "Model")
    private EntityManager em;

    @Resource
    private UserTransaction tx;

    @Override
    public String info() {
        TxInfo.txPrintInfo(tx);
        String t = null;
        try {
            tx.begin();
            t = em.toString();
            TxInfo.txPrintInfo(tx);

            int i = 0;
            System.out.println(10 / i);

            tx.commit();
            TxInfo.txPrintInfo(tx);
        } catch (NotSupportedException | SystemException | HeuristicRollbackException
                | RollbackException | HeuristicMixedException | ArithmeticException e) {
            System.out.println("Error " + e);
            try {
                tx.rollback();
                TxInfo.txPrintInfo(tx);
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
        }
        return t;
    }
}