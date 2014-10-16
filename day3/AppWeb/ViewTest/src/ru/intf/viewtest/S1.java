package ru.intf.viewtest;

import ru.intf.model.FacadeRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/s1")
public class S1 extends HttpServlet {
    private FacadeRemote f;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<hr/>");
        grandFather(out);
        out.print("</html>");
        out.close();
    }

    /**
     * Дедовский способ доступа к JNDI-каталогу.
     */
    private void grandFather(PrintWriter out) {
        Context ctx;
        try {
            ctx = new InitialContext();
            Object o = ctx.lookup("java:global/App1/Model/Facade!ru.intf.model.FacadeRemote");
//            Object o = ctx.lookup("java:app/Model/Facade!ru.intf.model.FacadeRemote");//NameNotFoundException
//            Object o = ctx.lookup("java:module/Facade!ru.intf.model.FacadeRemote");//NameNotFoundException
            out.print("<hr/>" + o);
        } catch (NamingException e) {
            out.print("<hr/>Error: " + e);
        }
    }
}