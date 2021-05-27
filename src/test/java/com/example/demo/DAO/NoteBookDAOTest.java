package com.example.demo.DAO;

import junit.framework.TestCase;

public class NoteBookDAOTest extends TestCase {




    public void testAdd() {
    NoteBookDAO noteBookDAO=new NoteBookDAO();

        assertEquals(3,noteBookDAO.add(1,2));
        assertEquals(4,noteBookDAO.add(2,2));


    }
}