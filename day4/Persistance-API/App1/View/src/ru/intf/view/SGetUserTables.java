package ru.intf.view;

import ru.intf.model.FacadeContainerManagementLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Выводит информацию о user_tables.
 */
@WebServlet(urlPatterns = "tables")
public class SGetUserTables extends HttpServlet {
    @EJB
    private FacadeContainerManagementLocal f;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        Object[] all = f.getUserTables();
        for (Object table : all) {
            final Object tableName = ((Object[]) table)[1];
            out.print("<hr/>" + tableName);
        }
        out.print("</html>");
        out.close();
    }
}