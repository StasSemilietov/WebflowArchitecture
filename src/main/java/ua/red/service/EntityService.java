package ua.red.service;

import ua.red.entity.CustomEntity;

import java.util.List;

/**
 * interface with service methods, add needed methods
 */
public interface EntityService {
    /**
     * get all entities
     * @return list of entities
     * */
    List<CustomEntity> getAll();
    /**
     * get entities by title field
     * @return list of entities
     * */
    List<CustomEntity> getEntityByTitle(String title);
    /**
     * get  entities by description field
     * @return list of entities
     * */
    List<CustomEntity> getEntityByDescription(String description);
    /**
     * get entities by regex in title
     * @return list of entities
     * */
    List<CustomEntity> getEntityByRegex(String regex);

    //TODO
}
