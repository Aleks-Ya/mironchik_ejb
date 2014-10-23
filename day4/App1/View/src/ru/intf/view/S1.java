package ru.intf.view;

import ru.intf.model.FacadeFulLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("s1")
public class S1 extends HttpServlet {
    @EJB
    private FacadeFulLocal f;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<html>");

        HttpSession sess = req.getSession();
        out.print("<hr/> Session id=" + sess.getId());
        out.print("<hr/> Session isNew=" + sess.isNew());
        out.print("<hr/> Creation time=" + new Date(sess.getCreationTime()));
        out.print("<hr/> Last access time=" + new Date(sess.getLastAccessedTime()));

        out.print("</html>");
        out.close();
    }
}