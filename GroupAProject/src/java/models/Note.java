
package models;

public class Note {
    private String noteid;
    private String title;
    private String contents;
    private String author;
    
    public Note() {
        noteid = "";
        title = "";
        contents = "";
        author = "";
    }
    
    public Note(String noteid, String title, String contents, String author) {
        this.noteid = noteid;
        this.title = title;
        this.contents = contents;
        this.author = author;
    }

    public String getNoteid() {
        return noteid;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public String getAuthor() {
        return author;
    }

    public void setNoteid(String noteid) {
        this.noteid = noteid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
}
