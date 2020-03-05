package converterfilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javaservlet.Student;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JsonConverterFilter implements Filter {
    private FilterConfig filterConfig;
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        filterConfig.getServletContext().log("converter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Object student = httpServletRequest.getAttribute("student");
        String host = httpServletRequest.getHeader("Accept");
        if (host.equals("application/json")) {
            servletResponse.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            String javatojson = mapper.writeValueAsString(student.toString());
            servletResponse.getWriter().write("json is working" + javatojson);

        } else if(host.equals("application/xml")){
            servletResponse.setContentType("application/xml");
            XmlMapper xmlmapper = new XmlMapper();
            String javatoxml = xmlmapper.writeValueAsString(student.toString());
            servletResponse.getWriter().write("xml is working" + javatoxml);
    }
        else
        {
                servletResponse.getWriter().write("data saved");
        }
    }
    public void destroy() {
    }
}
