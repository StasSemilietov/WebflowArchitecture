package ua.red.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.red.entity.CustomEntity;
import ua.red.repository.MongoCustomRepository;
import ua.red.repository.MongoKeywordsRepository;

import java.util.List;

/**
 * implementation of EntityService
 * override needed methods from EntityService interface
 */
@Service
public class EntityServiceImpl implements EntityService{
/**
 * autowired repositories
 * */
    @Autowired
    private MongoKeywordsRepository mongoKeywordsRepository;
    @Autowired
    private MongoCustomRepository mongoCustomRepository;


    @Override
    public List<CustomEntity> getAll() {
        return mongoKeywordsRepository.findAll();
    }

    @Override
    public List<CustomEntity> getEntityByTitle(String title) {
        return mongoKeywordsRepository.findByTitle(title);
    }

    @Override
    public List<CustomEntity> getEntityByDescription(String description) {
        return mongoKeywordsRepository.findByDescription(description);
    }

    @Override
    public List<CustomEntity> getEntityByRegex(String regex) {
        return mongoCustomRepository.searchEntityByRegexInTitle(regex);
    }

    //TODO
}
