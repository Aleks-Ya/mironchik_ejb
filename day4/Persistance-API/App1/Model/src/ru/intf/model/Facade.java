package ru.intf.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Facade implements FacadeLocal {
    @PersistenceContext(unitName = "Model")
    private EntityManager em;

    @Override
    public String info() {
        String t = em.toString();

        return t;
    }
}