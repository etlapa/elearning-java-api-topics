package mx.edev.elearning.topics.service;

import lombok.extern.slf4j.Slf4j;
import mx.edev.elearning.topics.domain.TopicChild;
import mx.edev.elearning.topics.domain.TopicTree;
import mx.edev.elearning.topics.domain.entities.TopicRelationEntity;
import mx.edev.elearning.topics.repositories.TopicJdbcTemplate;
import mx.edev.elearning.topics.repositories.TopicRelationRepository;
import mx.edev.elearning.topics.repositories.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TopicServices {

    private List<TopicTree> rootNodes = new ArrayList<>();

    private TopicRepository topicRepository;
    private TopicRelationRepository topicRelationRepository;
    private TopicJdbcTemplate topicJdbcTemplate;

    public TopicServices(TopicRepository topicRepository,
                         TopicRelationRepository topicRelationRepository,
                         TopicJdbcTemplate topicJdbcTemplate){
        this.topicRepository = topicRepository;
        this.topicRelationRepository = topicRelationRepository;
        this.topicJdbcTemplate = topicJdbcTemplate;
    }

    public List<TopicTree> getTopicTree(){

        rootNodes = this.topicRepository.findRootTopics()
                .stream().map(topic->{
                    log.debug("topic: [{}]",topic);
                    TopicTree rootNode = new TopicTree(topic.getId(),topic.getDescription());
                    log.debug("rootNode: [{}]",rootNode);
                    return rootNode;
                }).collect(Collectors.toList());

        Set<TopicRelationEntity> children = this.topicRelationRepository.getChildrenTopics();
        Set<TopicRelationEntity> retries = new HashSet<>();

        while(children.size()>0 || retries.size()>0){
            TopicRelationEntity currentChildTopic = children.iterator().next();
            children.remove(currentChildTopic);

            Long parentId = currentChildTopic.getTopicRelationPKEntity().getParent().getId();
            TopicTree foundNode = findParent(parentId,rootNodes);
            if(foundNode!=null){
                TopicTree child = new TopicTree(currentChildTopic.getTopicRelationPKEntity().getChild().getId(),
                        currentChildTopic.getTopicRelationPKEntity().getChild().getDescription());
                if(foundNode.getChildren()==null){
                    foundNode.setChildren(new ArrayList<>());
                }
                foundNode.getChildren().add(child);
            }else{
                retries.add(currentChildTopic);
            }
            if(children.isEmpty()&&retries.size()>0){
                children.addAll(retries);
                retries.removeAll(children);
            }
        }

        return rootNodes;
    }

    private TopicTree findParent(Long parentId, List<TopicTree> topics){
        TopicTree foundNode = null;

        TopicTree currentNode = null;
        for(int i=0;i<topics.size();i++){
            currentNode = topics.get(i);
            if(currentNode.getId().equals(parentId)){
                foundNode = currentNode;
                break;
            }
            if(currentNode.getChildren()!=null&&
                currentNode.getChildren().size()>0){
                foundNode = findParent(parentId,currentNode.getChildren());
                if(foundNode!=null){
                    break;
                }
            }
        }

        return foundNode;
    }
}