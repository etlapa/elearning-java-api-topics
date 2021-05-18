package mx.edev.elearning.topics.exceptions;

public class TopicNotFoundException extends RuntimeException{
    public TopicNotFoundException(Long id) {
        super("Could not find the product with ID: [" + id + "]");
    }
}