package by.efreet.gradle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/coupon")
public class CouponServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().print("SUPERSALE");
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse resp)
            throws ServletException, IOException {
        String coupon = rq.getParameter("coupon");
        rq.setAttribute("discount", "discount for coupon " + coupon + " is 50%");
        rq.getRequestDispatcher("response.jsp").forward(rq, resp);
    }
}
