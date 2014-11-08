package ru.intf.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Report implements Serializable {
    @Id
    private String ename;

    private String dname;

    private String job;

    private Long sal;

    @Transient
    private Long allSal;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getSal() {
        return sal;
    }

    public void setSal(Long sal) {
        this.sal = sal;
    }

    public Long getAllSal() {
        return allSal;
    }

    public void setAllSal(Long allSal) {
        this.allSal = allSal;
    }

    @PostLoad
    private void checkAllSale() {
        allSal = getSal() * 12;
    }

    @Override
    public String toString() {
        return "Report{" +
                "dname='" + dname + '\'' +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                ", allSal=" + allSal +
                '}';
    }
}