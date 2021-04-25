package com.post.servlet;

import com.post.enums.EnvelopeStatus;
import com.post.model.dao.EmployeeDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PendOrderServlet", value = "/PendOrderServlet")
public class PendOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trackingNumber = request.getParameter("trackingNumber");
        String description = request.getParameter("description");
        String status = request.getParameter("status");
        EnvelopeStatus envelopeStatus;
        if (status.equals("sending")) {
            envelopeStatus = EnvelopeStatus.sending;
        } else {
            envelopeStatus = EnvelopeStatus.Delivered;
        }
        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("username");
        EmployeeDao.PendingOrder(Integer.parseInt(trackingNumber), id, description, envelopeStatus);
        response.sendRedirect("PendingOrderSuccessful.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
