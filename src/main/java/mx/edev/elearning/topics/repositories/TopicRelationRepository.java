package mx.edev.elearning.topics.repositories;

import mx.edev.elearning.topics.domain.entities.TopicRelationEntity;
import mx.edev.elearning.topics.domain.entities.TopicRelationPKEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public interface TopicRelationRepository extends JpaRepository<TopicRelationEntity, TopicRelationPKEntity> {
    @Query(value = "SELECT top_id, top_description, tht_parent_id " +
            "FROM v_topic " +
            "JOIN topic_has_topic ON top_id=tht_child_id " +
            "ORDER BY top_description",
            nativeQuery = true)
    Collection<TopicRelationEntity> getChildrenTopicsSql();

    @Query("FROM TopicRelationEntity tr JOIN tr.topicRelationPKEntity.child t ORDER BY t.description")
    Set<TopicRelationEntity> getChildrenTopics();
}