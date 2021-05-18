package mx.edev.elearning.topics.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@JsonInclude(Include.NON_NULL)
public class TopicTree{
    private Long id;
    @JsonProperty("descr")
    private String description;
    private List<TopicTree> children;
    public TopicTree(){}
    public TopicTree(Long id){
        this.id=id;
    }
    public TopicTree(Long id, String description){
        this.id=id;
        this.description=description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TopicTree topicTree = (TopicTree) o;
        return id.equals(topicTree.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}