package mx.edev.elearning.topics.domain;

import lombok.Data;

@Data
public class TopicChild {
    private Long id;
    private String descr;
    private Long parentId;

    public TopicChild(Long id, String descr, Long parentId) {
        this.id = id;
        this.descr = descr;
        this.parentId = parentId;
    }
}
