package com.post.servlet;

import com.post.enums.PostType;
import com.post.model.dao.CustomerDao;
import com.post.model.entity.Envelope;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RequestpostServlet", value = "/RequestpostServlet")
public class RequestpostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        String Weight = request.getParameter("Weight");
        String Heightl = request.getParameter("Height");
        String width = request.getParameter("width");
        String Length = request.getParameter("Length");
        String material = request.getParameter("material");
        String address = request.getParameter("address3");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String address3 = request.getParameter("address4");
        String address4 = request.getParameter("address5");
        String address5 = request.getParameter("address6");
        String sur = address1 + address2 + address;
        String end = address4 + address5 + address3;
        String postTyp = request.getParameter("radio");
        PostType postType = null;
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("username");
        if (postTyp.equals("Premium")) {
            postType = PostType.Premium;
        } else if (postTyp.equals("Gold")) {
            postType = PostType.Gold;
        } else if (postTyp.equals("Silver")) {
            postType = PostType.silver;
        }
        Envelope envelope ;
        if (Heightl != null) {
            envelope = CustomerDao.requestDocumentPost(id, Float.parseFloat(Weight), sur, end, postType, Float.parseFloat(Heightl), Float.parseFloat(Length), Float.parseFloat(width), material);
        } else {
            envelope = CustomerDao.requestNonDocumentPost(id, Float.parseFloat(Weight), sur, end, postType);
        }
        session.setAttribute("trackingNumber", envelope.getTrackingNumber());
        response.sendRedirect("SuccessfulOrderRegistration.jsp");
        writer.println("</body></html>");
        writer.close();
    }
}

