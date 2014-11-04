package ru.intf.model.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;

/*
 CREATE TABLE emp (
    empno INT PRIMARY KEY,
    ename VARCHAR,
    job VARCHAR,
    sal INT,
    deptno INT,
    CONSTRAINT deptno_fk
    FOREIGN KEY(deptno)
    REFERENCES dept(deptno)
 );
 INSERT INTO emp (empno, ename, job, sal, deptno) VALUES (1, 'Вася', 'Директор', 1000000, 1);
 INSERT INTO emp (empno, ename, job, sal, deptno) VALUES (2, 'Петя', 'Замдиректора', 500000, 2);
 INSERT INTO emp (empno, ename, job, sal, deptno) VALUES (3, 'Маша', 'Секретарь', 100000, 2);
 */
@Entity(name = "Person")
@Table(name = "EMP")
public class Person implements Serializable {
    @Column(name = "ENAME")
    private String name;
    private String job;
    @Id
    @Column(name = "EMPNO")
    private Long id;
    @Column(name = "SAL")
    private BigInteger salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}
