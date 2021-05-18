package mx.edev.elearning.topics.domain;

import lombok.Data;

@Data
public class TopicErrorResponse {
    private final String code;
    private final String description;
    public TopicErrorResponse(String code, String description){
        this.code=code;
        this.description=description;
    }
}
