package com.example.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.DAO.NoteBookDAO;
import com.example.demo.DAO.NotesDAO;
import com.example.demo.model.NoteBook;
import com.example.demo.model.User;

public class NoteBookServlet extends HttpServlet {

	
	
	 public void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	    {
		 
		 	HttpSession session=request.getSession();
		 	User user=(User)session.getAttribute("userobj");
		 	session.removeAttribute("noteBook");
		 	NoteBookDAO notebook=new NoteBookDAO();
		 	NotesDAO notedao=new NotesDAO();
		 	List<NoteBook> notebooks =notebook.listOfNoteBook(user);
		 	Map<NoteBook,Integer> notebookMap = new HashMap<NoteBook,Integer>();  
		 	for(NoteBook nb:notebooks) {
			     Integer count=notedao.getNumberOfNotes(nb);
			     notebookMap.put(nb,count);
			}
		 	
		 	request.setAttribute("NoteBookList", notebookMap);
		 	request.setAttribute("user",user);
	    	request.getRequestDispatcher("notebook.jsp").forward(request, response);
	    }
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	    {
	    	HttpSession s=request.getSession();
			s.removeAttribute("user");
	    	request.getRequestDispatcher("notebook.jsp").forward(request, response);
	    }
	    
	   
	    
}
