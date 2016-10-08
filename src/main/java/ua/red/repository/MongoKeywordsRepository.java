package ua.red.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.red.entity.CustomEntity;

import java.util.List;

/**
 * Use this repository for query methods with supported keywords
 * @link http://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo.repositories
 * add needed methods
 */
public interface MongoKeywordsRepository extends MongoRepository<CustomEntity, String> {
    /**
     * EXAMPLES:
     */
    List<CustomEntity> findAll();
    List<CustomEntity> findByTitle(String title);
    List<CustomEntity> findByDescription(String description);
    //TODO
}
