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

public class SignupServlet extends HttpServlet {
	


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobile = request.getParameter("phone");

        User user = new User(username,password,email,mobile);
        UserDAO userDAO = new UserDAO();
        String result = userDAO.createUser(user);
        if(result.equals("1062")){
            request.setAttribute("errMessage", "Email, username or Mobile already Exists");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }

    }
    
    
    
    public void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	request.getRequestDispatcher("/signup.jsp").forward(request, response);
    }
    
   

}
