package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

public class ServletContextListener implements javax.servlet.ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("************************************************************************************");
        ServletContext servletContext = servletContextEvent.getServletContext();
        System.out.println(servletContext+"started");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("************************************************************************************");
        ServletContext servletContext = servletContextEvent.getServletContext();
        System.out.println(servletContext+"destroyed");
    }
}
