package com.post.servlet;

import com.post.service.PostService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "RegisterCustomerServlet", value = "/RegisterCustomerServlet")
public class RegisterCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        String userName = request.getParameter("user");
        String password = request.getParameter("pass");
        String phone = request.getParameter("phon");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String state = request.getParameter("address");
        String city = request.getParameter("address1");
        String address = request.getParameter("address2");
        PostService.registerCustomer(password, Long.parseLong(phone), email, state, city, address, name, userName);
        HttpSession session = request.getSession();
        session.setAttribute("username", userName);
        response.sendRedirect("customerPage.jsp");
        writer.println("</body></html>");
        writer.close();

    }
}
