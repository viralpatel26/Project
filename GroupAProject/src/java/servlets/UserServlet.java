package servlets;

import services.UserService;
import models.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;
import services.NoteService;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        NoteService ns = new NoteService();
        String action = request.getParameter("action");
        if (action != null && action.equals("view")) {
            String selectedNote = request.getParameter("selectedNote");
            try {
                Note note = ns.get(selectedNote);
                request.setAttribute("selectedNote", note);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ArrayList<Note> notes = null;        
        try {
            notes = (ArrayList<Note>) ns.getAll();
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("notes",notes);
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String noteid = request.getParameter("noteid"); 
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        String author = request.getParameter("author");

        NoteService ns = new NoteService();

        try {
            if (action.equals("delete")) {
                String selectedNote = request.getParameter("selectedNote");
                ns.delete(selectedNote);
            } else if (action.equals("edit")) {
                ns.update(noteid, title, contents, author);
            } else if (action.equals("add")) {
                ns.insert(noteid, title, contents, author);
            }
        } catch (Exception ex) {
            request.setAttribute("errorMessage", "Whoops.  Could not perform that action.");
        }
        
        ArrayList<Note> notes = null;        
        try {
            notes = (ArrayList<Note>) ns.getAll();
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("notes",notes);
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
}
