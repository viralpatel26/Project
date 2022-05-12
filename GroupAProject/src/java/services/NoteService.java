package services;

import database.NoteDB;
import models.Note;
import java.util.List;


public class NoteService {
    
    private NoteDB noteDB;
    
    public NoteService() {
        noteDB = new NoteDB();
    }
    //Task 8: Insert method
    public int insert(String noteid, String title, String contents, String author) throws Exception {
        Note note = new Note(noteid, title, contents, author);
        return noteDB.insert(note);
    }
    //Task 9: Update method
    public int update(String noteid, String title, String contents, String author) throws Exception {
        Note note = get(noteid);
        note.setTitle(title);
        note.setAuthor(author);
        note.setContents(contents);
        return noteDB.update(note);
    }    
    //Task 10: Delete method
    public int delete(String noteid) throws Exception{
        Note deletedNote = noteDB.getNote(noteid);
        return noteDB.delete(deletedNote);
    }
    //Task 11: Get method
    public Note get(String noteid) throws Exception{
        return noteDB.getNote(noteid);
    }
    //Task 12: GetAll Method
    public List<Note> getAll() throws Exception{
        return noteDB.getAll();
    }
}