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

/**
 * Вызывает бин с транзакцией, управляемой контейнером.
 * Вызов нативных SQL-запросов.
 */
@WebServlet(urlPatterns = "container")
public class SContainerManagement extends HttpServlet {
    @EJB
    private FacadeContainerManagementLocal f;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        try {
            f.execSQL("insert into t1 values (1); commit");
//            f.execSQL("commit");
        } catch (Exception e) {
            out.print("<hr/>" + e);
        }
        out.print("</html>");
        out.close();
    }
}