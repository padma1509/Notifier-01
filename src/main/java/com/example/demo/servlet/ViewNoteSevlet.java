package com.example.demo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.DAO.NotesDAO;
import com.example.demo.model.Note;

public class ViewNoteSevlet extends HttpServlet{

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		
		response.sendRedirect("note");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		String noteid=request.getParameter("noteid");
		if(noteid==null)
		{
			response.sendRedirect("note");
			return;
		}
		Integer id=Integer.parseInt(noteid);
		
		NotesDAO notesdao=new NotesDAO();
		Note note=notesdao.getNoteObject(id);
		System.out.println(note.toString());
		request.setAttribute("note", note);
		request.getRequestDispatcher("viewNote.jsp").forward(request, response);
	}
}