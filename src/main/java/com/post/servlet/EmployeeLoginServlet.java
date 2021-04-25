package com.post.servlet;

import com.post.service.PostService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmployeeLoginServlet", value = "/EmployeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        if (PostService.checkLoginForEmployee(userName, password)) {
            response.sendRedirect("EmployeePage.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("username", userName);
        } else {
            writer.println("Wrong username or password entered");
            request.getRequestDispatcher("employeeform.html").include(request, response);
        }
        writer.println("</body></html>");
        writer.close();
    }
    }

