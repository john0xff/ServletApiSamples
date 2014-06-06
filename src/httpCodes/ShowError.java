package httpCodes;
// Import required java libraries
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Extend HttpServlet class
@WebServlet("/5.Servlets-Http_Codes/ShowError")
public class ShowError extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Method to handle GET method request.
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Set error code and reason.
		response.sendError(407, "Need authentication!!! greetings from ShowError Servlet ");
	}

	// Method to handle POST method request.
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}