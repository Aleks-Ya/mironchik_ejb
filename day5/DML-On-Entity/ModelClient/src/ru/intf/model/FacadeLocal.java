package ru.intf.model;

import java.math.BigDecimal;
import java.util.List;

public interface FacadeLocal {
    List<DeptEntity> getDeptAll();

    List<DeptEntity> getDeptBySal(BigDecimal s);

    EmpEntity getEmpById(int id);

    void updateEmp(int empno, BigDecimal salary);
}