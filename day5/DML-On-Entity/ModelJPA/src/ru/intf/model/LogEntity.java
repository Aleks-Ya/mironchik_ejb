package ru.intf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Лог в БД.
 */
/*
CREATE SEQUENCE jpa_update.logId START 1;
CREATE TABLE jpa_update.log_table(
  id integer NOT NULL DEFAULT nextval('jpa_update.logId'),
  message character varying(1000),
  CONSTRAINT log_table_pk PRIMARY KEY (id)
)
 */
@Entity
@Table(name = "log_table", schema = "jpa_update")
@SequenceGenerator(name = "log_id_generator", schema = "jpa_update", sequenceName = "logid", allocationSize=1)
public class LogEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "log_id_generator", strategy = GenerationType.SEQUENCE)
    private int id;

    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String text) {
        this.message = text;
    }
}
