package ru.intf.model;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerHandle;
import java.util.Collection;
import java.util.Date;

@Stateless
public class Facade implements FacadeLocal {
    private TimerHandle th = null;

    @Resource
    private SessionContext sess;

    @Override
    public void startJob() {
        if (th == null) {
            th = sess.getTimerService().createTimer(new Date(), 2000, "TimerJob").getHandle();
        }
    }

    @Override
    public void stopJob() {
//        if (th != null) {
//            th.getTimer().cancel();
//            th = null;
//        }
        Collection<Timer> a = sess.getTimerService().getTimers();
        for (Timer timer : a) {
            timer.cancel();
        }
    }

    @Timeout
    public void invokeJob(Timer t) {
        if (t.getInfo().equals("TimerJob")) {
            System.out.println("---------------- " + new Date());
        }
    }
}