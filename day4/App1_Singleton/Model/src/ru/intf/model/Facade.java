package ru.intf.model;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Бин для обращения к бину MySingle.
 */
@Stateless
public class Facade implements FacadeLocal {
    @EJB
    private MySingleLocal s;

    @Override
    public String m1() {
        return s.getInfo();
    }
}