package web.command;

import db.exceptions.AppException;
import org.apache.log4j.Logger;
import web.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PaymentFromOrdersCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException, AppException {

        Logger LOG = Logger.getLogger(PaymentFromOrdersCommand.class);
        HttpSession session = request.getSession();
        session.setAttribute("price",request.getParameter("price"));
        LOG.trace("Set the session attribute: price --> " + request.getParameter("price"));
        session.setAttribute("orderId",Integer.parseInt(request.getParameter("orderId")));
        LOG.trace("Set the session attribute: orderId --> " + request.getParameter("orderId"));
        return Path.PAGE_PAYMENT;
    }
}
