package mx.edev.elearning.topics.domain.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="topic_has_topic")
public class TopicRelationEntity {

    @EmbeddedId
    private TopicRelationPKEntity topicRelationPKEntity;

//    @Column(name = "tht_parent_id")
//    private Long parentId;
//    @Column(name = "tht_child_id")
//    private Long childId;
}