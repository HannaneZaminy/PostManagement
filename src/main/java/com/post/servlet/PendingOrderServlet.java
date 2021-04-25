package com.post.servlet;

import com.post.model.dao.EnvelopDao;
import com.post.model.entity.Envelope;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "PendingOrderServlet", value = "/PendingOrderServlet")
public class PendingOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String id = (String) session.getAttribute("username");
        List<Envelope> envelopes=new ArrayList<>();
        envelopes = EnvelopDao.fetchAllEnvelop();
      //  System.out.println(envelopes.size());
        List<Envelope> envelopeList = envelopes.stream().filter(envelope -> id.equals(envelope.getEmployeeName())).collect(Collectors.toList());
        request.setAttribute("ST", envelopeList);
        System.out.println(envelopeList.size());
        envelopes.clear();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("PendingOrder.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(false);
//        String id = (String) session.getAttribute("username");
//        List<Envelope> envelopes = EnvelopDao.fetchAllEnvelop();
//        List<Envelope> envelopeList = envelopes.stream().filter(envelope -> envelope.getEmployeeName() == id).collect(Collectors.toList());
//        request.setAttribute("ST", envelopeList);
//
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("PendingOrder.jsp");
//        requestDispatcher.forward(request, response);
    }
}

