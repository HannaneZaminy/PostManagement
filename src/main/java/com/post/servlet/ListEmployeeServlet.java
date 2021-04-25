package com.post.servlet;

import com.post.model.dao.EmployeeDao;
import com.post.model.dao.EnvelopDao;
import com.post.model.entity.Employee;
import com.post.model.entity.Envelope;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ListEmployeeServlet", value = "/ListEmployeeServlet")
public class ListEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = EmployeeDao.fetch();
        request.setAttribute("ST",employees);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListEmployee.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
