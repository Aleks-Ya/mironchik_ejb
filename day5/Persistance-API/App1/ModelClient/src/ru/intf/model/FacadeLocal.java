package ru.intf.model;

import javax.ejb.Local;
import java.util.List;

@Local
public interface FacadeLocal {
    List<Report> getReports(int id);
}