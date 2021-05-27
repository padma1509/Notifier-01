package com.example.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.DAO.UserDAO;
import com.example.demo.model.User;

public class LoginServlet extends HttpServlet {
	


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
 
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("inside login servelet");
      
        
        UserDAO userdao =new UserDAO();
        User user = userdao.authUser(email,password);
 
        if(user!=null)
         {
        	HttpSession s=request.getSession();
			
			s.setAttribute("userobj", user);
        	response.sendRedirect("notebook");
         }
         else
         {
        	 
             request.setAttribute("errMessage", "Username or password incorrect"); //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
             request.getRequestDispatcher("index.jsp").forward(request, response);//forwarding the request
         }
    }
    
    
    
    public void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
   

}
