package com.post.servlet;

import com.post.model.dao.EnvelopDao;
import com.post.model.dao.EnvelopeInformationDao;
import com.post.model.entity.Envelope;
import com.post.model.entity.EnvelopeInformation;
import com.post.service.PostService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "TrakeOrderServlet", value = "/TrakeOrderServlet")
public class TrakeOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        String trackingNumber = request.getParameter("trackingNumber");
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("username");
        Envelope envelope = PostService.checkMachCustomerAndEnvelope(Integer.parseInt(trackingNumber), userName);
        if (envelope != null) {
            List<EnvelopeInformation> envelopeInformation = EnvelopeInformationDao.fetch();
            List<EnvelopeInformation> informations = envelopeInformation.stream().filter(envelopeInformation1 -> envelopeInformation1.getEnvelope().equals(envelope)).collect(Collectors.toList());
            request.setAttribute("ST", informations);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("TrackOrder.jsp");
            requestDispatcher.forward(request, response);
        } else {
            writer.println("Error:Customization with this profile is not registered for you!!");
            request.getRequestDispatcher("CheckStatus.jsp").include(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}
