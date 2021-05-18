package mx.edev.elearning.topics.controllers;

import lombok.extern.slf4j.Slf4j;
import mx.edev.elearning.topics.domain.entities.TopicEntity;
import mx.edev.elearning.topics.domain.TopicTree;
import mx.edev.elearning.topics.repositories.TopicRepository;
import mx.edev.elearning.topics.service.TopicServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("v1/topics")
public class TopicsController {

    private TopicRepository topicRepository;
    private TopicServices topicServices;

    public TopicsController(TopicRepository topicRepository,TopicServices topicServices){
        this.topicRepository = topicRepository;
        this.topicServices = topicServices;
    }

    @GetMapping()
    public List<TopicTree> getAll(){
        return this.topicServices.getTopicTree();
    }

    @PostMapping()
    public TopicEntity newProduct(@RequestBody TopicEntity newTopic) {
        //TODO: uncomment
//        return topicRepository.save(newTopic);
        return null;
    }

    @GetMapping("/{id}")
    public TopicEntity getOne(@PathVariable Long id) {
        //TODO: uncomment
//        return topicRepository.findById(id).orElseThrow(
//                () -> new TopicNotFoundException(id)
//        );
        return null;
    }

    @PutMapping("/{id}")
    public TopicEntity replaceProduct(@RequestBody TopicEntity newProduct, @PathVariable Long id) {

        log.debug("Updating product: [{}], [{}]", id, newProduct);

        //TODO: uncomment
//        return topicRepository.findById(id)
//                .map(product -> {
////                    product.setPath(newProduct.getPath());
//                    product.setDescription(newProduct.getDescription());
//                    return topicRepository.save(product);
//                })
//                .orElseGet(() -> {
//                    newProduct.setId(id);
//                    return topicRepository.save(newProduct);
//                });
        return null;
    }

    @PatchMapping("/{id}")
    public TopicEntity patchProduct(@RequestBody TopicEntity newProduct, @PathVariable Long id) {

        log.debug("Updating topic: [{}], [{}]", id, newProduct);

        //TODO: uncomment
//        return topicRepository.findById(id)
//                .map(product -> {
//                    product.setDescription(newProduct.getDescription());
//                    return topicRepository.save(product);
//                })
//                .orElseThrow(
//                        ()->new TopicNotFoundException(id)
//                );
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){
        TopicEntity topic = new TopicEntity();
//        topic.setPath("forbidden path");
        topic.setDescription("forbidden description");
        return new ResponseEntity(topic,HttpStatus.OK);
    }
}