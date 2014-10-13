package ru.intf.view;

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
        out.print("</html>");
        out.close();
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("----Servlet id=" + id + " destroyed.");
    }
}
