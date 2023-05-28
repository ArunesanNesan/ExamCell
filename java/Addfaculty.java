import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ Addfaculty ")
public class Addfaculty extends jakarta.servlet.http.HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Connection con=DBUtil.createconnection();
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	String query="insert into addfaculty values(?,?)";
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,username);
		ps.setString(2,password);
		int rowcount=ps.executeUpdate();
		if(rowcount>=1) {
			RequestDispatcher r=request.getRequestDispatcher("success.html");
			r.forward(request, response);
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	}

	
	
	}
}