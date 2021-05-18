package mx.edev.elearning.topics.exceptions;

import mx.edev.elearning.topics.domain.TopicErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TopicNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(TopicNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public TopicErrorResponse productNotFoundHandler(TopicNotFoundException ex) {
        return new TopicErrorResponse(HttpStatus.NOT_FOUND.toString(),ex.getMessage());
    }
}
