package ru.intf.model;

import javax.ejb.Stateless;

@Stateless
public class A1 implements I1Remote, I1Local {
    private Long id;

    public A1() {
        this.id = System.currentTimeMillis();
        System.out.println("==========Bean id=" + id + " crated.===========");
    }

    @Override
    public String info() {
        return "Привет, Мир!";
    }
}