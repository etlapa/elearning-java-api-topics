package mx.edev.elearning.topics.repositories;

import mx.edev.elearning.topics.domain.entities.TopicEntity;
import mx.edev.elearning.topics.domain.entities.TopicRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.Collection;

//TODO: take a loot at:
//https://stackoverflow.com/questions/19062453/java-sq-sqlexception-column-not-found
//https://stackshare.io/stackups/javafx-vs-react-native-desktop

@Service
public interface TopicRepository extends JpaRepository<TopicEntity,Long> {
    @Query(value = "SELECT top_id, top_description " +
            "FROM v_topic " +
            "LEFT JOIN topic_has_topic ON top_id=tht_child_id " +
            "WHERE tht_child_id IS NULL " +
            "ORDER BY top_description",
            nativeQuery = true)
    Collection<TopicEntity> findRootTopicsSql();

    @Query("SELECT t FROM TopicEntity t " +
            "WHERE not exists (SELECT 1 FROM TopicRelationEntity tr " +
            "WHERE tr.topicRelationPKEntity.child=t) " +
            "ORDER BY t.description")
    Collection<TopicEntity> findRootTopics();
}