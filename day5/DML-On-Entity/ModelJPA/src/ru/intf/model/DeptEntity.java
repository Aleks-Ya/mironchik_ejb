package ru.intf.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "dept", schema = "public", catalog = "mironchik2")
@NamedQueries(value = {
        @NamedQuery(
                name = "dept.getAll",
                query = "SELECT d FROM DeptEntity d")
})
public class DeptEntity {
    private Integer deptno;
    private String dname;
    private Collection<EmpEntity> empsByDeptno;

    @Id
    @Column(name = "deptno")
    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    @Basic
    @Column(name = "dname")
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeptEntity that = (DeptEntity) o;

        if (deptno != null ? !deptno.equals(that.deptno) : that.deptno != null) return false;
        if (dname != null ? !dname.equals(that.dname) : that.dname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = deptno != null ? deptno.hashCode() : 0;
        result = 31 * result + (dname != null ? dname.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "deptByDeptno", fetch = FetchType.EAGER)
    public Collection<EmpEntity> getEmpsByDeptno() {
        return empsByDeptno;
    }

    public void setEmpsByDeptno(Collection<EmpEntity> empsByDeptno) {
        this.empsByDeptno = empsByDeptno;
    }

    @Override
    public String toString() {
        return "DeptEntity{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", empsByDeptno=" + empsByDeptno +
                '}';
    }
}
