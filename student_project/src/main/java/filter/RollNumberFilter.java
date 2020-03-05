package filter;

import javax.servlet.*;
import java.io.IOException;

public class RollNumberFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.getWriter().write("filter is working");
        String rollnumber = servletRequest.getParameter("rollnumber");
        String pattern = "RN[0-9]+";
        if(rollnumber.matches(pattern)) {
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else {
            servletResponse.getWriter().write("invalid rollnumber type");
        }
    }
    public void destroy() {
    }
}

