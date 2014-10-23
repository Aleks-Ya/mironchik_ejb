package ru.intf.model;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * EJB-бин без использования интерфейсов.
 */
@Stateless
@LocalBean
public class WorkNoInterface {
    public String info(int c) {
        return "No Interface " + c;
    }
}