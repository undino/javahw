package org.itstep.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class CounterUsersListener implements HttpSessionListener {

    public static int countListener = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        countListener++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        countListener--;
    }

}
