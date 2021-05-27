package com.example.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.DAO.NoteBookDAO;
import com.example.demo.DAO.NotesDAO;
import com.example.demo.model.Note;
import com.example.demo.model.NoteBook;

public class DeleteNoteServlet  extends HttpServlet{

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		Integer id=Integer.parseInt(request.getParameter("noteId"));
		NotesDAO notesdao=new NotesDAO();
		Note note=notesdao.getNoteObject(id);
		notesdao.deleteNote(note);
		response.sendRedirect("note");
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		
		Integer id=Integer.parseInt(request.getParameter("noteId"));
		NotesDAO notesdao=new NotesDAO();
		Note note=notesdao.getNoteObject(id);
		notesdao.deleteNote(note);
		response.sendRedirect("note");
		
	}
}