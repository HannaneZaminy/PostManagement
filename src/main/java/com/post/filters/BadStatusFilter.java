package com.post.filters;

import com.post.enums.EnvelopeStatus;
import com.post.model.dao.EnvelopDao;
import com.post.model.entity.Envelope;
import com.post.service.PostService;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "BadStatusFilter")
public class BadStatusFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        String trackingNumber = request.getParameter("trackingNumber");
        String status = request.getParameter("status");
        EnvelopeStatus envelopeStatus;
        if (status.equals("sending")) {
            envelopeStatus = EnvelopeStatus.sending;
        } else {
            envelopeStatus = EnvelopeStatus.Delivered;

        }
        Envelope envelop = EnvelopDao.findEnvelop(Integer.parseInt(trackingNumber));
        if(envelop.getLastStatus()==EnvelopeStatus.Delivered && envelopeStatus==EnvelopeStatus.sending){
            writer.println("Delivered order can not be changed");
            request.getRequestDispatcher("PendingOrder.jsp").include(request, response);
        }
        else {
            chain.doFilter(request, response);
        }
        writer.println("</body></html>");
        writer.close();
    }
}
