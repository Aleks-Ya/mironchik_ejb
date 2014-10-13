package ru.intf;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class Jdbc {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName("org.postgresql.Driver");
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                final Driver driver = drivers.nextElement();
                System.out.println(driver.getClass() + " v." + driver.getMajorVersion() + "." + driver.getMinorVersion());
            }

            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mironchik2", "postgres", "postgres");
            System.out.println(conn.getMetaData().getDatabaseProductVersion());
            System.out.println("Connected...");
            System.out.println("Autocommit: " + conn.getAutoCommit());

            st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS tab()");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
