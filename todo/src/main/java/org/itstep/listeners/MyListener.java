package org.itstep.listeners;

import org.itstep.db.ToDoDao;
import org.itstep.entity.ToDo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");
        ToDoDao toDoDao = applicationContext.getBean("toDoDao", ToDoDao.class);
        toDoDao.createDb();
        System.out.println("START LISTENER");
        ServletContext context = sce.getServletContext();
        context.setAttribute("toDoDao", toDoDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }


}
