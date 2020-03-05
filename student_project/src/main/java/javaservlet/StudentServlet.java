package javaservlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentServlet extends HttpServlet {
    public void init() throws ServletException {
        super.init();
    }

    String name;

    public StudentServlet() {
        super();
    }

    Map<String, Student> hashmap = new HashMap<>();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String rollnumber = req.getParameter("rollnumber");
        String university = req.getParameter("university");
        Student s = new Student(rollnumber, name, university);
        hashmap.put(rollnumber, s);
        resp.getWriter().write("Student" + hashmap.get(rollnumber));
        req.setAttribute("student", s);
        //getServletContext().setAttribute("map", hashmap);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           String rollnumber = req.getParameter("rollnumber");
         if(hashmap.containsKey(rollnumber))
         {
             Object data = hashmap.get(rollnumber);
             resp.getWriter().write(data.toString());
             req.setAttribute("data",data);


         }
    }
    public void destroy() {
        super.destroy();
        getServletConfig().getServletContext().log("destroying");
    }
}
