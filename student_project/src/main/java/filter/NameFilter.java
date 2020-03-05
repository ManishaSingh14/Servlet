package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class NameFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (((HttpServletRequest) servletRequest).getMethod().equals("POST")) {
            String name = servletRequest.getParameter("name");
            String p = "[a-z]+";
            if (name.matches(p)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                servletResponse.getWriter().write("invalid name");
            }
        }
    }
    public void destroy() {

    }
}
