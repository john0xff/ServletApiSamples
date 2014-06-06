package databaseAccess;
// Loading required libraries
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/10.Servlets-Database_Access/DatabaseAccess")
public class DatabaseAccess extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatabaseAccess()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connection successful");
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String host = "localhost";
		int port = 3306;
		String database = "servlets_api_samples";

		String url = "jdbc:mysql://" + host + ":" + String.valueOf(port) + "/" + database;
		String username = "root";
		String password = "";

		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Database Result";
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\">\n" + "<h1 align=\"center\">" + title + "</h1>\n");

		PrintWriter writer = response.getWriter();
		try
		{
			Connection connection = (Connection) DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			String sql = "SELECT id, first, last, age FROM Employees";
			ResultSet resultset = statement.executeQuery(sql);
			while (resultset.next())
			{
				// Retrieve by column name
				int id = resultset.getInt("id");
				int age = resultset.getInt("age");
				String first = resultset.getString("first");
				String last = resultset.getString("last");

				// Display values
				out.println("ID: " + id);
				out.println(", Age: " + age);
				out.println(", First: " + first);
				out.println(", Last: " + last + "<br>");
			}
			out.println("</body></html>");

			writer.close();

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}