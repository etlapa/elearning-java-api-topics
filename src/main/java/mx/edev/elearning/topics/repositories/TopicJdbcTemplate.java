package mx.edev.elearning.topics.repositories;

import mx.edev.elearning.topics.domain.TopicChild;
import mx.edev.elearning.topics.domain.TopicTree;
import mx.edev.elearning.topics.domain.entities.TopicEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TopicJdbcTemplate {
    private JdbcTemplate jdbcTemplate;
    public TopicJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
//    private static final class TrackMapper implements RowMapper<Track> {
//        @Override
//        public Track mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//            Track track = new Track();
//            track.setId(resultSet.getInt("id"));
//            track.setName(resultSet.getString("name"));
//            track.setCategoryId(resultSet.getInt("category_id"));
//            return track;
//        }
//    }
//    public List<Track> getTracks(int categoryId) {
//        String sql = "SELECT id, name FROM track WHERE category_id = " + categoryId + " ORDER BY name";
//        return jdbcTemplate.query(sql, new TrackMapper());
//    }
    public Collection<TopicChild> findRootTopics(){
        String sql = "SELECT top_id, top_description, tht_parent_id FROM v_topic JOIN topic_has_topic ON top_id=tht_child_id ORDER BY top_description";
        return jdbcTemplate.query(sql, new TopicChildrenMapper());
    }
}