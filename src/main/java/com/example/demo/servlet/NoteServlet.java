package com.example.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.DAO.NoteBookDAO;
import com.example.demo.DAO.NotesDAO;
import com.example.demo.model.Note;
import com.example.demo.model.NoteBook;
import com.example.demo.model.User;

public class NoteServlet extends HttpServlet{

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		request.getRequestDispatcher("Notes.jsp").forward(request, response);
	
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		HttpSession session=request.getSession();
	 	
	 	
	 	String notebookId=request.getParameter("notebookId");
	 	Integer id;
	 	if(notebookId==null)
	 	{
	 		NoteBook nb=(NoteBook) session.getAttribute("noteBook");
	 	
	 		if(nb==null)
	 		{
	 			response.sendRedirect("notebook");
	 			return;
	 		}
	 		id = nb.getId();
	 	}else {
	 		id = Integer.parseInt(notebookId);
	 	}
		
		
		
		NoteBookDAO notebookdao =new NoteBookDAO();
		NoteBook  notebook=notebookdao.getNoteBookObject(id);
		session.setAttribute("noteBook", notebook);
		
		NotesDAO notesdao = new NotesDAO();
		List<Note> notelist =notesdao.listOfNotes(id);
		
		request.setAttribute("NoteList", notelist);
		request.setAttribute("NoteBookId", id);
	 	
		request.getRequestDispatcher("Notes.jsp").forward(request, response);

	}
}