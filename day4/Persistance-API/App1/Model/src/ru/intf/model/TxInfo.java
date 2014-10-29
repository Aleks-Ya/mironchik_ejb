package ru.intf.model;

import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Печатает в консоль текущее состояние транзакции.
 */
public class TxInfo {
    public static void txPrintInfo(UserTransaction tx) {
        try {
            switch (tx.getStatus()) {
                case Status.STATUS_ACTIVE:
                    System.out.println("======== STATUS_ACTIVE");
                    break;
                case Status.STATUS_COMMITTED:
                    System.out.println("======== STATUS_COMMITTED");
                    break;
                case Status.STATUS_COMMITTING:
                    System.out.println("======== STATUS_COMMITTING");
                    break;
                case Status.STATUS_MARKED_ROLLBACK:
                    System.out.println("======== STATUS_MARKED_ROLLBACK");
                    break;
                case Status.STATUS_NO_TRANSACTION:
                    System.out.println("======== STATUS_NO_TRANSACTION");
                    break;
                case Status.STATUS_PREPARED:
                    System.out.println("======== STATUS_PREPARED");
                    break;
                case Status.STATUS_ROLLEDBACK:
                    System.out.println("======== STATUS_ROLLEDBACK");
                    break;
                case Status.STATUS_UNKNOWN:
                    System.out.println("======== STATUS_UNKNOWN");
                    break;
                case Status.STATUS_PREPARING:
                    System.out.println("======== STATUS_PREPARING");
                    break;
                case Status.STATUS_ROLLING_BACK:
                    System.out.println("======== STATUS_PREPARING");
                    break;
                default:
                    throw new RuntimeException();
            }
        } catch (SystemException e) {
            e.printStackTrace();
        }
    }
}