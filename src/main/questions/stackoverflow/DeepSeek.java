import java.util.*;

class User {
    String userId;
    String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

class Tag {
    String tagId;
    String name;

    public Tag(String tagId, String name) {
        this.tagId = tagId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return tagId.equals(tag.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId);
    }
}

class Topic {
    String topicId;
    String name;

    public Topic(String topicId, String name) {
        this.topicId = topicId;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return topicId.equals(topic.topicId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topicId);
    }
}

class Question {
    String questionId;
    String title;
    String description;
    User author;
    Set<Tag> tags;
    Set<Topic> topics;
    Date timestamp;

    public Question(String questionId, String title, String description, User author) {
        this.questionId = questionId;
        this.title = title;
        this.description = description;
        this.author = author;
        this.tags = new HashSet<>();
        this.topics = new HashSet<>();
        this.timestamp = new Date();
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId='" + questionId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author=" + author.name +
                ", tags=" + tags +
                ", topics=" + topics +
                ", timestamp=" + timestamp +
                '}';
    }
}

class StackOverflowService {
    Map<String, User> users;
    Map<String, Question> questions;
    Map<String, Tag> tags;
    Map<String, Topic> topics;

    public StackOverflowService() {
        this.users = new HashMap<>();
        this.questions = new HashMap<>();
        this.tags = new HashMap<>();
        this.topics = new HashMap<>();
    }

    public void registerUser(String userId, String name) {
        users.put(userId, new User(userId, name));
    }

    public void addTag(String tagId, String name) {
        tags.put(tagId, new Tag(tagId, name));
    }

    public void addTopic(String topicId, String name) {
        topics.put(topicId, new Topic(topicId, name));
    }

    public void postQuestion(String questionId, String title, String description, String userId, List<String> tagIds, List<String> topicIds) {
        User author = users.get(userId);
        if (author == null) {
            throw new RuntimeException("User not found");
        }

        Question question = new Question(questionId, title, description, author);
        for (String tagId : tagIds) {
            Tag tag = tags.get(tagId);
            if (tag != null) {
                question.addTag(tag);
            }
        }
        for (String topicId : topicIds) {
            Topic topic = topics.get(topicId);
            if (topic != null) {
                question.addTopic(topic);
            }
        }
        questions.put(questionId, question);
    }

    public List<Question> searchByTag(String tagName) {
        List<Question> result = new ArrayList<>();
        for (Question question : questions.values()) {
            for (Tag tag : question.tags) {
                if (tag.name.equalsIgnoreCase(tagName)) {
                    result.add(question);
                    break;
                }
            }
        }
        return result;
    }

    public List<Question> searchByTopic(String topicName) {
        List<Question> result = new ArrayList<>();
        for (Question question : questions.values()) {
            for (Topic topic : question.topics) {
                if (topic.name.equalsIgnoreCase(topicName)) {
                    result.add(question);
                    break;
                }
            }
        }
        return result;
    }
}

public class DeepSeek {
    public static void main(String[] args) {
        StackOverflowService stackOverflow = new StackOverflowService();

        // Register users
        stackOverflow.registerUser("U1", "Alice");
        stackOverflow.registerUser("U2", "Bob");

        // Add tags
        stackOverflow.addTag("T1", "Java");
        stackOverflow.addTag("T2", "Python");

        // Add topics
        stackOverflow.addTopic("TO1", "Programming");
        stackOverflow.addTopic("TO2", "Web Development");

        // Post questions
        stackOverflow.postQuestion("Q1", "How to use Java Streams?", "I need help with Java Streams.", "U1", Arrays.asList("T1"), Arrays.asList("TO1"));
        stackOverflow.postQuestion("Q2", "Django vs Flask?", "Which one is better for web development?", "U2", Arrays.asList("T2"), Arrays.asList("TO2"));

        // Search by tag
        List<Question> javaQuestions = stackOverflow.searchByTag("Java");
        System.out.println("Questions with tag 'Java':");
        for (Question question : javaQuestions) {
            System.out.println(question);
        }

        // Search by topic
        List<Question> programmingQuestions = stackOverflow.searchByTopic("Programming");
        System.out.println("Questions with topic 'Programming':");
        for (Question question : programmingQuestions) {
            System.out.println(question);
        }
    }
}