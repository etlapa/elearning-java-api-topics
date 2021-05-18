package mx.edev.elearning.topics.domain;

import lombok.Data;

import java.util.List;

@Data
//TODO: delete this class
public class TopicTreeListResponse {
    private List<TopicTree> rootNodes;
}