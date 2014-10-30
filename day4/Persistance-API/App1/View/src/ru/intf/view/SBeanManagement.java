package ru.intf.view;

import ru.intf.model.FacadeBeanManagementLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Вызывает бин, самостоятельно управляющий своей транзакцией.
 */
@WebServlet(urlPatterns = "bean")
public class SBeanManagement extends HttpServlet {
    @EJB
    private FacadeBeanManagementLocal f;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.print("<hr/>" + f.info());
        out.print("</html>");
        out.close();
    }
}