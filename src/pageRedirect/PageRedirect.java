package pageRedirect;
import java.io.*;
import java.sql.Date;
import java.util.*;

import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/13.Servlets-Page_Redirect/PageRedirect")
public class PageRedirect extends HttpServlet{
    
  @SuppressWarnings("static-access")
public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Set response content type
      response.setContentType("text/html");

      // New location to be redirected
      String site = new String("http://www.phoenixjcam.com");

      response.setStatus(response.SC_MOVED_TEMPORARILY);
      response.setHeader("Location", site);    
    }
} 