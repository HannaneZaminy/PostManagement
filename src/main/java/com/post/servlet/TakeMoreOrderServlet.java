package com.post.servlet;



import com.post.model.dao.EnvelopDao;
import com.post.model.entity.Envelope;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

//@WebServlet(name = "TakeMoreOrderServlet", value = "/TakeMoreOrderServlet")
public class TakeMoreOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Envelope> envelopes = EnvelopDao.fetchAllEnvelop();
        List<Envelope> envelopeList = envelopes.stream().filter(envelope -> envelope.getEmployeeName() == null).collect(Collectors.toList());
        request.setAttribute("ST",envelopeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("TakeMoreOrders.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Envelope> envelopes = EnvelopDao.fetchAllEnvelop();
        List<Envelope> envelopeList = envelopes.stream().filter(envelope -> envelope.getEmployeeName() == null).collect(Collectors.toList());
        request.setAttribute("ST",envelopeList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("TakeMoreOrders.jsp");
        requestDispatcher.forward(request, response);
    }
}
