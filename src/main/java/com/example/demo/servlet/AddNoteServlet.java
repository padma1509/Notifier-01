package com.example.demo.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.DAO.NotesDAO;
import com.example.demo.model.Note;
import com.example.demo.model.NoteBook;
import com.example.demo.model.Status;
import com.example.demo.model.Tag;
import com.example.demo.model.User;

public class AddNoteServlet  extends HttpServlet{

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		 HttpSession session=request.getSession();
		 User user = (User) session.getAttribute("userobj");
		 String name = request.getParameter("noteName");
		 String startDate = request.getParameter("startDate");
		 String endDate = request.getParameter("endDate");
		 String remainderDate = request.getParameter("remainderDate");
		 String statusName = request.getParameter("noteStatus");
		 String tagName = request.getParameter("noteTag");
		 String noteDescription=request.getParameter("noteDescription");
		 
		 NoteBook notebook =(NoteBook)session.getAttribute("noteBook");
			
		 
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 
		
			java.sql.Date start_date=null;
			java.sql.Date end_date=null;
			java.sql.Date remainder_date=null;
			try {
				java.util.Date start_Date = sdf.parse(startDate);
				start_date = new java.sql.Date(start_Date.getTime());

				java.util.Date end_Date = sdf.parse(endDate);
				end_date = new java.sql.Date(end_Date.getTime());

				java.util.Date remainder_Date = sdf.parse(remainderDate);
				remainder_date = new java.sql.Date(remainder_Date.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		Status status =new Status(statusName);
		
		Tag tag=new Tag(tagName);
		
		Note note=new Note();
		
		note.setNoteName(name);
		note.setStartDate(start_date);
		note.setEndDate(end_date);
		note.setRemainderDate(remainder_date);
		note.setStatus(status);
		note.setTag(tag);
		note.setNoteDescription(noteDescription);
		note.setNoteBook(notebook);
		note.setUser(user);
		
		
		NotesDAO notedao=new NotesDAO();
		notedao.createNote(note);
		response.sendRedirect("note");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		System.out.print("get Method---");
		response.sendRedirect("note");
	}
}