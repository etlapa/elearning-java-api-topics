package mx.edev.elearning.topics.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "v_topic")
public class TopicEntity {

    @Id @GeneratedValue
    @Column(name = "top_id")
    private Long id;

    @Column(name = "top_description")
    private String description;
}