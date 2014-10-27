package ru.intf.view;

import ru.intf.model.FacadeFulLocal;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Удаление EJB-бина после таймаута сессии.
 */
@WebListener
public class SessionListener implements HttpSessionListener {
//    @EJB
//    private FacadeFulLocal f;

    public SessionListener() {
        System.out.println("------ Constructor Session Listener");
    }

    public void sessionCreated(HttpSessionEvent se) {
        FacadeFulLocal f = null;
        Context ctx;
        try {
            ctx = new InitialContext();
            Object o = ctx.lookup("java:global/App1/Model/FacadeFul!ru.intf.model.FacadeFulLocal");
            System.out.println(o);
            f = (FacadeFulLocal) o;
        } catch (NamingException e) {
            e.printStackTrace();
        }

        HttpSession session = se.getSession();
        System.out.println("----------- Web Session Created: " + session.getId());
        session.setAttribute("facade", f);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("----------- Web Session Destroyed: " + session.getId());
        ((FacadeFulLocal) session.getAttribute("facade")).myRemove();
    }
}