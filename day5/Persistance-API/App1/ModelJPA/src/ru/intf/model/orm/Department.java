package ru.intf.model.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
CREATE TABLE dept (
    deptno INT PRIMARY KEY,
    dname VARCHAR
 );
 INSERT INTO dept (deptno, dname) VALUES (1, 'Департамент развития');
 INSERT INTO dept (deptno, dname) VALUES (2, 'Департамент деградации');
*/
@Entity
@Table(name = "dept")
public class Department {
    @Id
    @Column(name = "deptno")
    private Long id;

    @Column(name = "dname")
    private String name;
}