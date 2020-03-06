package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServletContextListener implements javax.servlet.ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("************************************************************************************");
        ServletContext servletContext = servletContextEvent.getServletContext();
        String path = servletContext.getInitParameter("path");
        System.out.println(servletContext + "started");
        InputStream in = null;
        try {
            in = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(in);
            servletContext.setAttribute("properties",prop);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

}
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("************************************************************************************");
        ServletContext servletContext = servletContextEvent.getServletContext();
        System.out.println(servletContext+"destroyed");
    }
}
