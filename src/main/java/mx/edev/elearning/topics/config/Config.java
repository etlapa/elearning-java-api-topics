package mx.edev.elearning.topics.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private static final int MAX_ITEMS = 10;

//    @Bean
//    public CommandLineRunner initDatabase(TopicRepository repository) {
//        return args -> {
//            for (int i = 1; i <= MAX_ITEMS; i++) {
//                LOGGER.info("Preloading " + repository.save(new Topic("AWS > A Cloud Guru > ", "Topic " + i)));
//            }
//        };
//    }
}