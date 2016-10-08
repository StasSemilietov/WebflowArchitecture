package ua.red.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ua.red.entity.CustomEntity;

import java.util.List;

/**
 * Use this repository for custom queries
 * add needed methods
 */
@Repository
public class MongoCustomRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * EXAMPLE:
     * Find entities which title contains regex
     * @param string for custom search
     * @return list of entities from custom query
     * */
    public List<CustomEntity> searchEntityByRegexInTitle(String regex){
        return mongoTemplate.find(Query.query(Criteria.where("title").regex(regex, "i")), CustomEntity.class);
    }
}
