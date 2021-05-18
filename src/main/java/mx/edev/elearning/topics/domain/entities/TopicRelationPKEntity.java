package mx.edev.elearning.topics.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Embeddable
public class TopicRelationPKEntity implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tht_parent_id", referencedColumnName = "top_id")
    private TopicEntity parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tht_child_id", referencedColumnName = "top_id")
    private TopicEntity child;
}