package com.post.filters;

import com.post.service.PostService;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(filterName = "CheckForDuplicateEmailFilter")
public class CheckForDuplicateEmailFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        String email = request.getParameter("email");
        if (PostService.checkRegisterByEmail(email)) {
            writer.println("Error:emai already exists");
            request.getRequestDispatcher("customerform.html").include(request, response);
        } else {
            chain.doFilter(request, response);
        }
        writer.println("</body></html>");
        writer.close();
    }
}
