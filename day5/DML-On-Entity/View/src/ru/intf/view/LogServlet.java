package ru.intf.view;

import ru.intf.model.LogLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Тестовый сервлет для сохранения лога.
 */
@WebServlet(urlPatterns = "log")
public class LogServlet extends HttpServlet {

    @EJB
    LogLocal logger;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        String message = "Today is " + new Date();
        logger.log(message);
        out.print("<hr/>Log message: " + message);
        out.print("</html>");
        out.close();
    }
}