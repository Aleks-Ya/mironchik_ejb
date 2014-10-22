package ru.view;

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
 * Асинхронный вызов метода EJB-бина (без возвращаемого значения).
 */
@WebServlet(urlPatterns = "/s3void")
public class SAsyncVoid extends HttpServlet {

    @EJB
    private FacadeLocal f;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<hr/>");
        out.print("<hr/>" + f.testAsynch());
        out.print("</html>");
        out.close();
    }
}