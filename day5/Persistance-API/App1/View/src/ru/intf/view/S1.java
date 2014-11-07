package ru.intf.view;

import ru.intf.model.FacadeLocal;
import ru.intf.model.Report;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = "reports")
public class S1 extends HttpServlet {
    @EJB
    private FacadeLocal f;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        final List<Report> reports = f.getReports(1);
        for (Report report : reports) {
            out.print("<hr/>" + report);
        }
        out.print("</html>");
        out.close();
    }
}