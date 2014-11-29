package ru.intf.model;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * EJB-бин для логирования.
 */
@Singleton
public class LogBean implements LogLocal {
    @PersistenceContext(unitName = "PostgreSQLxa-user-u")
    EntityManager emU;

    @Override
    public void log(String message) {
        LogEntity log = new LogEntity();
        log.setMessage(message);
        emU.persist(log);
    }
}