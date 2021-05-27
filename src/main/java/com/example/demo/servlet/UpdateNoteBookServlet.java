package com.example.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.DAO.NoteBookDAO;
import com.example.demo.model.NoteBook;

public class UpdateNoteBookServlet  extends HttpServlet{

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		
		Integer id=Integer.parseInt(request.getParameter("notebookId"));
		String notebookName=request.getParameter("notebookName");
		String notebookDescription=request.getParameter("notebookDescription");
		NoteBookDAO notebook=new NoteBookDAO();
		notebook.updateNoteBook(id, notebookName,notebookDescription);
		response.sendRedirect("notebook");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		response.sendRedirect("notebook");
		
	}
}