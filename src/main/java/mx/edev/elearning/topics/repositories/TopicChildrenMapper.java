package mx.edev.elearning.topics.repositories;

import mx.edev.elearning.topics.domain.TopicChild;
import mx.edev.elearning.topics.domain.TopicTree;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicChildrenMapper implements RowMapper<TopicChild> {
    @Override
    public TopicChild mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TopicChild(rs.getLong("top_id"),
                rs.getString("top_description"),
                rs.getLong("tht_parent_id"));
    }
}
