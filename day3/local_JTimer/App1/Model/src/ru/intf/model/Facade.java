package ru.intf.model;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerHandle;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Stateless
public class Facade implements FacadeLocal {
    private TimerHandle th = null;

    @Resource
    private SessionContext sess;

    @EJB
    private WorkAsynchLocal w;

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

    @Override
    public String testAsynch() {
        w.info1();
        return "Метод выполнен";
    }

    @Override
    public String testAsynchWithFuture() {
        Future f = w.infoWithFuture();
        try {
//            Person p = (Person) f.get();
            Person p = (Person) f.get(4, TimeUnit.SECONDS);
            return String.format("Метод выполнен: %s %s %s", p.getFn(), p.getSn(), p.getInfo());
        } catch (InterruptedException e) {
            return e.toString();
        } catch (ExecutionException e) {
            return e.toString();
        } catch (TimeoutException e) {
            return "Время истекло";
        }
    }

    @Timeout
    public void invokeJob(Timer t) {
        if (t.getInfo().equals("TimerJob")) {
            System.out.println("---------------- " + new Date());
        }
    }
}