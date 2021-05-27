package com.example.demo;



import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;

import com.example.demo.DAO.UserDAO;

import java.io.IOException;
        import java.io.PrintWriter;


public class App extends HttpServlet {

	 public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      UserDAO user=new UserDAO();
		      user.testFun();
		      response.setContentType("text/html");

		      // Actual logic goes here.
		      PrintWriter out = response.getWriter();
		      out.println("<h1> </h1>");
		   }

}

