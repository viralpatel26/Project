package database;

import models.Note;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NoteDB {
    
    // Task 3: Adds a new note to the database.
    public int insert(Note note) throws NotesDBException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        try {
            String preparedQuery = "INSERT INTO notes (noteid, title, contents, author) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(preparedQuery);
            ps.setString(1, note.getNoteid());
            ps.setString(2, note.getTitle());
            ps.setString(3, note.getContents());
            ps.setString(4, note.getAuthor());
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot insert note", ex);
            throw new NotesDBException("Error inserting note");
        } finally {
            pool.freeConnection(connection);
        }
    }
    
    // Task 4: Updates the record for an existing note in the database.
    public int update(Note note) throws NotesDBException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        try {
            String preparedSQL = "UPDATE notes SET title = ?, contents = ?, author = ? WHERE noteid = ?";
            PreparedStatement ps = connection.prepareStatement(preparedSQL);
            
            ps.setString(1, note.getTitle());
            ps.setString(2, note.getContents());
            ps.setString(3, note.getAuthor());
            ps.setString(4, note.getNoteid());
            
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot update note" + note.toString(), ex);
            throw new NotesDBException("Error updating note");
        } finally {
            pool.freeConnection(connection);
        }
    }
    
    // Task 5: Deletes the record for an existing note in the database.
    public int delete(Note note) throws NotesDBException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String preparedQuery = "DELETE FROM notes WHERE noteid = ?";
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(preparedQuery);
            ps.setString(1, note.getNoteid());
            int rows = ps.executeUpdate();
            return rows;
        } catch (SQLException ex) {
            Logger.getLogger(NoteDB.class.getName()).log(Level.SEVERE, "Cannot delete note", ex);
            throw new NotesDBException("Error deleting note");
        } finally {
            pool.freeConnection(connection);
        }
    }
    
    // Task 6: Retrieves the record for an existing note by the Note ID.
    public Note getNote(String noteid) throws NotesDBException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM notes WHERE noteid = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(selectSQL);
            ps.setString(1, noteid);
            rs = ps.executeQuery();

            Note note = null;
            while (rs.next()) {
                note = new Note(rs.getString("noteid"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getString("author"));
            }
            pool.freeConnection(connection);
            return note;
        } catch (SQLException ex) {
            Logger.getLogger(NoteDB.class.getName()).log(Level.SEVERE, "Cannot read note", ex);
            throw new NotesDBException("Error getting note");
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
    }
    
    // Task 7: Retrieves all of the notes.
    public List<Note> getAll() throws NotesDBException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement("SELECT * FROM notes;");
            rs = ps.executeQuery();
            List<Note> notes = new ArrayList<>();
            while (rs.next()) {
                notes.add(new Note(rs.getString("noteid"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getString("author")));
            }
            pool.freeConnection(connection);
            return notes;
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, "Cannot read notes", ex);
            throw new NotesDBException("Error getting notes");
        } finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException ex) {
            }
            pool.freeConnection(connection);
        }
    }
}