package stackoverflow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StackOverFlow {
    private final Map<Integer, User> users;
    private final Map<Integer, Question> questions;
    private final Map<Integer, Answer> answers;
    private final Map<String, Tag> tags;

    public StackOverFlow() {
        this.users = new ConcurrentHashMap<>();
        this.questions = new ConcurrentHashMap<>();
        this.answers = new ConcurrentHashMap<>();
        this.tags = new ConcurrentHashMap<>();
    }

    public User createUser(String userName, String email){
        int id = users.size() +1 ;
        User u = new User(id, userName, email);
        users.put(id, u);
        return u;
    }

    public Question addQuestion(User user, String title, String content, List<String> tags){
        Question q = user.askQuestion(title, content, tags);
        questions.put(q.getId(), q);
        return q;
    }

    public Answer addAnswer(User user, Question q, String content){
        Answer a = user.addAnswer(q, content);
        answers.put(a.getId(), a);
        return a;
    }

    /**
     * Commentable is used here because
     * the comment can be on a question or an answer
     * */
    public void addComment(User user, Commentable commentable, String content){
        user.addComment(commentable, content);
    }

    public void voteQuestion(User u, int val, Question q){
        q.addVote(u,val);
    }

    public void voteAnswer(User u, int val, Answer a){
        a.addVote(u, val);
    }

    public void acceptAnswer(Answer a){
        a.markAsAccepted();
    }

    public List<Question> searchForQuestion (String query){
        return questions.values().stream()
                .filter(q->q.getTitle().contains(query)
                        ||q.getContent().contains(query)
                        || q.getTags().stream().anyMatch(t->t.getName().equalsIgnoreCase(query)))
                .collect(Collectors.toList());
    }

    public List<Question> getQuestionsByUser(User u){
        return u.getQuestions();
    }

    public User getUser(int id){
        return this.users.get(id);
    }

    public Question getQuestion(int id){
        return this.questions.get(id);
    }

    public Answer getAnswer(int id){
        return this.answers.get(id);
    }

    public Tag getTag(String name){
        return tags.get(name);
    }

}
