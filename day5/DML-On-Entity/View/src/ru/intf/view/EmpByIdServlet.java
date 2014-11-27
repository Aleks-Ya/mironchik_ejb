package ru.intf.view;

import ru.intf.model.EmpEntity;
import ru.intf.model.FacadeLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Служащий по id.
 */
@WebServlet(urlPatterns = "emp")
public class EmpByIdServlet extends HttpServlet {

    @EJB
    FacadeLocal f;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        EmpEntity emp = f.getEmpById(1);
        out.print("<hr/>" + emp);
        out.print("<br/>" + emp.getDeptByDeptno().getDname());
        out.print("</html>");
        out.close();
    }
}