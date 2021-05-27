package com.example.demo.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.DAO.NoteBookDAO;
import com.example.demo.DAO.NotesDAO;
import com.example.demo.model.*;

public class UpdateNoteServlet  extends HttpServlet{

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("userobj");

		Integer noteBookId=Integer.parseInt(request.getParameter("notebookId"));
		Integer id=Integer.parseInt(request.getParameter("noteId"));
		String noteName=request.getParameter("noteName");
		String noteDescription=request.getParameter("noteDescription");
		String startDate= request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String remainderDate = request.getParameter("remainderDate");
		String statusName=request.getParameter("noteStatus");
		String tagName=request.getParameter("noteTag");
		
		NoteBook noteBook = new NoteBook();
		NoteBookDAO notebookdao=new NoteBookDAO();
		noteBook = notebookdao.getNoteBookObject(noteBookId);

		java.sql.Date start_date=null;
		java.sql.Date end_date = null;
		java.sql.Date remainder_date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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

		Note noteObj = new Note();
		NotesDAO notesdao = new NotesDAO();
		noteObj = notesdao.getNoteObject(id);

		Status status = new Status(noteObj.getStatus().getId(), statusName);
		Tag tag = new Tag(noteObj.getTag().getId(), tagName);
		Note note = new Note(id, noteName, noteDescription, start_date, end_date, remainder_date, status, tag,
				noteBook, user);
		notesdao.updateNote(note);

		noteBook = (NoteBook) session.getAttribute("noteBook");
		
		response.sendRedirect("note?notebookId="+noteBook.getId());
			
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
	}
}