package stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class Answer implements Commentable{
    private final int id;
    private final User author;
    private final List<Vote> votes;
    private final List<Comment> comments;
    private final Question question;
    private final String content;
    private boolean accepted;


    public Answer(User author, Question question, String content) {
        this.id = generateId();
        this.author = author;
        this.votes = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.question = question;
        this.content = content;
        this.accepted = false;
    }

    public int generateId(){
        return (int) System.currentTimeMillis() % Integer.MAX_VALUE;
    }

    @Override
    public void addComment(Comment c){
        this.comments.add(c);
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
        author.setReputation(author.getReputation()+(val*10));
    }

    public int getVoteCount(){
        int totalVote = 0;
        for(Vote vote: votes){
            totalVote+=vote.getValue();
        }
        return totalVote;
    }

    public void markAsAccepted(){
        accepted = true;
        author.setReputation(author.getReputation()+15);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public Question getQuestion() {
        return question;
    }

    public String getContent() {
        return content;
    }

    public boolean isAccepted() {
        return accepted;
    }
}
