package model.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginClass
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class LoginClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
    	RequestDispatcher rd= request.getRequestDispatcher("Login.html");
    	rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("username");
		String pwd=request.getParameter("password");
		if(un.equals("Lalit")&&pwd.equals("star"))
		{
			RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
			request.setAttribute("name", un);
			request.setAttribute("password", pwd);
			
			rd.forward(request, response);
		}
		else
		{
			response.sendRedirect("error.html");
		}
		
	}

}
