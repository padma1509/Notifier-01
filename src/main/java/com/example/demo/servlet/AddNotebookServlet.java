package com.example.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.DAO.NoteBookDAO;
import com.example.demo.model.NoteBook;
import com.example.demo.model.User;

public class AddNotebookServlet extends HttpServlet{

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		String noteBookName=request.getParameter("notebookName");
		String notebookDescription=request.getParameter("notebookDescription");
		

	 	HttpSession session=request.getSession();
	 	User user=(User)session.getAttribute("userobj");
	 	
	 	
		NoteBook notebook=new NoteBook();
		notebook.setUser(user);
		notebook.setNoteBookName(noteBookName);
		notebook.setNoteBookDescription(notebookDescription);
		
		NoteBookDAO notebookdao=new NoteBookDAO();
		notebookdao.createNoteBook(notebook);
		
		response.sendRedirect("notebook");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		response.sendRedirect("notebook");
	}
}
