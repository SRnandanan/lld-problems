package stackoverflow;

import java.util.Date;

public class Comment {
    private final int id;
    private final String content;
    private final User author;
    private final Date creationDate;

    public Comment(String content, User author) {
        this.id = generateId();
        this.content = content;
        this.author = author;
        this.creationDate = new Date();
    }

    public int generateId(){
        return (int) System.currentTimeMillis() % Integer.MAX_VALUE;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreationDate() {
        return creationDate;
    }
}
