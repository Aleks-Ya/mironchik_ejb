package ru.view;

import ru.intf.model.FacadeFullLocal;
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
 * Вызов методов stateful бина.
 */
@WebServlet(urlPatterns = "/stateful")
public class SStateful extends HttpServlet {

    @EJB
    private FacadeFullLocal fl;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<hr/>" + fl.info());
        fl.myRemove();
        out.print("</html>");
        out.close();
    }
}