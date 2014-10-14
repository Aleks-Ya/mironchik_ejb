package ru.intf.view;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/s1", loadOnStartup = 10)
public class Servlet extends HttpServlet {
    private long id;

    @Override
    public void init() throws ServletException {
        super.init();
        id = System.currentTimeMillis();
        System.out.println("----Servlet id=" + id + " created.");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.print("<hr/>Привет, Мир!");
        Thread t = Thread.currentThread();
        out.print("<hr/>Thread =" + t);

        Context ctx = null;
        try {
            ctx = new InitialContext();
            NamingEnumeration<NameClassPair> ne = ctx.list("java:jboss");
            while (ne.hasMoreElements()) {
                Object o = ne.nextElement();
                out.print("<hr/>" + o);
            }
            Object exampleDs = ctx.lookup("java:jboss/datasources/ExampleDS");
            out.print("<hr/>" + exampleDs);
        } catch (Exception e) {
            e.printStackTrace(out);
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (NamingException e) {
                    e.printStackTrace(out);
                }
            }
        }

        out.print("</html>");
        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("----Servlet id=" + id + " destroyed.");
    }
}
