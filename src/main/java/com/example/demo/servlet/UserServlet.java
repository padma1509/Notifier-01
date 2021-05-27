package com.example.demo.servlet;

import com.example.demo.DAO.UserDAO;
import com.example.demo.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Integer userId = (Integer.parseInt( request.getParameter("userId")));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        User user = new User(userId, userName, password,email,mobile );
        UserDAO userDAO = new UserDAO();
        userDAO.updateUser(user);
        System.out.println("user updated");

        request.getRequestDispatcher("note").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
