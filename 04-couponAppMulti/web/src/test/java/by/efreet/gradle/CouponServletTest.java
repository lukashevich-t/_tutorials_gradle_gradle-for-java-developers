package by.efreet.gradle;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CouponServletTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher requestDispatcher;

    @Before
    public void setUp() throws Exception {
        // MockitoAnnotations.initMocks(this);
        MockitoAnnotations.openMocks(this).close();
    }

    @Test
    public void doGet() throws Exception {
        System.out.printf("MockitoAnnotations: %s", MockitoAnnotations.class.getCanonicalName());
        System.out.printf("request: %s", request.getClass().getCanonicalName());
        System.out.printf("response: %s", response.getClass().getCanonicalName());
        System.out.printf("requestDispatcher: %s", requestDispatcher.getClass().getCanonicalName());

        StringWriter sw = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(sw));
        new CouponServlet().doGet(request, response);
        assertEquals("SUPERSALE", sw.toString());
    }

    @Test
    public void doPost() throws Exception {
        when(request.getParameter("coupon")).thenReturn("SUPERSALE");
        when(request.getRequestDispatcher("response.jsp")).thenReturn(requestDispatcher);
        new CouponServlet().doPost(request, response);
        verify(request).setAttribute("discount", "discount for coupon SUPERSALE is 50%");
        verify(request).getRequestDispatcher("response.jsp");
        verify(requestDispatcher).forward(request, response);
    }
}
