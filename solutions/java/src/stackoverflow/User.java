package stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int id;
    private final String username;
    private final String email;
    private int reputation;
    private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;

    private static final int QUEST_REP = 3;
    private static final int ANS_REP = 5;
    private static final int COMM_REP = 1;


    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.reputation = 0;
    }

    public void addComment(Commentable commentable, String content){
        Comment c = new Comment(content, this);
        commentable.addComment(c);
        this.comments.add(c);
        this.reputation+=COMM_REP;
    }

    public Question askQuestion(String title, String content, List<String> tags){
        Question q = new Question(title, this, content, tags);
        this.questions.add(q);
        this.reputation+=QUEST_REP;
        return q;
    }

    public Answer addAnswer(Question q, String content){
        Answer a = new Answer(this, q, content);
        this.answers.add(a);
        this.reputation+=ANS_REP;
        return a;
    }

    public int getId() {
        return id;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getUsername() {
        return username;
    }
}
