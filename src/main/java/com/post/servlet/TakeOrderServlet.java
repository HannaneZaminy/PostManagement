package com.post.servlet;



import com.post.model.dao.EmployeeDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TakeOrderServlet", value = "/TakeOrderServlet")
public class TakeOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trackingNumber = request.getParameter("trackingNumber");
        String description = request.getParameter("description");
        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("username");
        EmployeeDao.takeMoreOrder(Integer.parseInt(trackingNumber),id,description);
        response.sendRedirect("TrackingOrderSuccessful.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trackingNumber = request.getParameter("trackingNumber");
        String description = request.getParameter("description");
        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("username");
        EmployeeDao.takeMoreOrder(Integer.parseInt(trackingNumber),"hanazam",description);
        response.sendRedirect("TrackingOrderSuccessful.jsp");
    }
}
