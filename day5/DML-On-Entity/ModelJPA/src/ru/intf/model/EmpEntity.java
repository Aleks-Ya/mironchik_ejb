package ru.intf.model;

import javax.persistence.*;

/**
 * Служаший.
 */
@Entity
@Table(name = "emp", schema = "public")
public class EmpEntity {
    private Integer empno;
    private String ename;
    private String job;
    private Integer sal;
    private DeptEntity deptByDeptno;

    @Id
    @Column(name = "empno")
    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    @Basic
    @Column(name = "ename")
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "job")
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Basic
    @Column(name = "sal")
    public Integer getSal() {
        return sal;
    }

    public void setSal(Integer sal) {
        this.sal = sal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpEntity empEntity = (EmpEntity) o;

        if (empno != null ? !empno.equals(empEntity.empno) : empEntity.empno != null) return false;
        if (ename != null ? !ename.equals(empEntity.ename) : empEntity.ename != null) return false;
        if (job != null ? !job.equals(empEntity.job) : empEntity.job != null) return false;
        if (sal != null ? !sal.equals(empEntity.sal) : empEntity.sal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = empno != null ? empno.hashCode() : 0;
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (sal != null ? sal.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "deptno", referencedColumnName = "deptno")
    public DeptEntity getDeptByDeptno() {
        return deptByDeptno;
    }

    public void setDeptByDeptno(DeptEntity deptByDeptno) {
        this.deptByDeptno = deptByDeptno;
    }

    @Override
    public String toString() {
        return "EmpEntity{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                '}';
    }
}
