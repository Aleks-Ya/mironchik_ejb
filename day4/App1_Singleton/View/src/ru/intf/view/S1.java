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

/**
 * В браузере открыть ссылку http://localhost:8080/view/s1
 * и несколько раз подряд нажать Обновить.
 */
@WebServlet(urlPatterns = "/s1")
public class S1 extends HttpServlet {
    @EJB
    private FacadeLocal f;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<html>");
        f.m1();
        out.print("<hr/>");
        out.print("</html>");
        out.close();
    }
}