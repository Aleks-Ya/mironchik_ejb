package ru.intf.view;

import ru.intf.model.DeptEntity;
import ru.intf.model.FacadeLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "S1", urlPatterns = "sal")
public class SalServlet extends HttpServlet {

    @EJB
    FacadeLocal f;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        List<DeptEntity> deptBySal = f.getDeptBySal(new BigDecimal(700000));
        for (DeptEntity dept : deptBySal) {
            out.print("<hr/>" + dept);
        }
        out.print("</html>");
        out.close();
    }
}