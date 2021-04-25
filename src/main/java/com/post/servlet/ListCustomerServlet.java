package com.post.servlet;

import com.post.model.dao.CustomerDao;
import com.post.model.dao.EmployeeDao;
import com.post.model.entity.Customer;
import com.post.model.entity.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "ListCustomerServlet", value = "/ListCustomerServlet")
public class ListCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = CustomerDao.fetch();
      //  List<String> collect = customers.stream().map(customer -> customer.getUserName()).collect(Collectors.toList());
        List<Integer> collect1 = customers.stream().map(customer -> customer.getEnvelopes().size()).collect(Collectors.toList());
        request.setAttribute("ST",customers);
        request.setAttribute("SZ",collect1);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListCustomer.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
