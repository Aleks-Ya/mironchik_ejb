package ru.intf.view;

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

/**
 * Обновляет зарплату у служащего.
 */
@WebServlet(urlPatterns = "update")
public class UpdateEmpServlet extends HttpServlet {

    @EJB
    FacadeLocal f;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        f.updateEmp(1, BigDecimal.valueOf(3_000_000));
        out.print("</html>");
        out.close();
    }
}