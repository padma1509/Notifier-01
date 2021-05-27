package com.example.demo.servlet;

import com.example.demo.DAO.NotesDAO;
import com.example.demo.model.Note;
import com.example.demo.model.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListOfNotesServlet  extends HttpServlet{

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("userobj");
		NotesDAO notesdao = new NotesDAO();
		List<Note> notelist =notesdao.listOfNotesByUser(user.getId());
		request.setAttribute("NoteList", notelist);

		request.getRequestDispatcher("allNotes.jsp").forward(request, response);
	}
}