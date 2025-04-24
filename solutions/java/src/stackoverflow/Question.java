package stackoverflow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Commentable {
    private final int id;
    private final String title;
    private final User author;
    private final Date creationDate;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Vote> votes;
    private final String content;
    private final List<Tag> tags;


    public Question(String title, User author, String content, List<String> tagNames) {
        this.id = generateId();
        this.title = title;
        this.author = author;
        this.creationDate = new Date();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.content = content;
        this.tags = new ArrayList<>();
        for(String tag: tagNames){
            this.tags.add(new Tag(tag));
        }
    }

    public int generateId(){
        return (int) System.currentTimeMillis() % Integer.MAX_VALUE;
    }

    /**
     * Adds upvote or downvote;
     * */
    public void addVote(User user, int val){
        if(val!=1 && val!=-1){
            throw new IllegalArgumentException("Value must be 1 or -1");
        }
        votes.removeIf(v->v.getUser().equals(user));
        Vote v = new Vote(user, val);
        votes.add(v);
        author.setReputation(author.getReputation()+(val*5));
    }

    public int getVoteCount(){
        int totalVote = 0;
        for(Vote vote: votes){
            totalVote+=vote.getValue();
        }
        return totalVote;
    }

    @Override
    public void addComment(Comment c){
        this.comments.add(c);

    }

    public void addAnswer(Answer a){
        if(!this.answers.contains(a)){
            this.answers.add(a);
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
