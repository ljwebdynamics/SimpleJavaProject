package model.servlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeClass
 */

public class HomeClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Empdb","postgres", "root");
	         System.out.println("Opened database successfully ji");
	         
	         Statement st=c.createStatement();
	         ResultSet rs=st.executeQuery("select * from employee");
	         List<String> namesList=new ArrayList<String>();
	         while(rs.next())
	         {
	        	namesList.add(rs.getString("name"));
	         }
	        
	         rs.close();
	         st.close();
	         c.close();
	     System.out.println("closed database successfully");
	     request.setAttribute("names", namesList);
	 System.out.println(request.getParameter("user"));
	     RequestDispatcher rd=request.getRequestDispatcher("show.jsp");
	     rd.forward(request,response);
	     
	     
	      } catch (Exception e) {
	         System.out.println(e);
	      }
	    
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
