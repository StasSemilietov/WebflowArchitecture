package ua.red.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.red.entity.CustomEntity;
import ua.red.service.EntityService;

import java.util.List;

/**
 * realisation of Facade pattern
 * permanently keeps list of entities according to queries, searchCriteria from JSF, etc
 * add needed methods, services, etc
 */
@Component
@Scope("singleton")
public class EntityFacade {
    /***
     * searchCriteria, defined in JSF( like menu or link according to design
     */
    @Autowired
    private SearchCriteria searchCriteria;
    /***
     * Service
     */
    @Autowired
    private EntityService entityService;

/***
 * list of entities
 */
    private List<CustomEntity> entityList;

/***
 * getter for entityList, if null - used getAll() method from service
 */
    public List<CustomEntity> getEntityList() {
        if (entityList==null) entityList =  entityService.getAll();
        return entityList;
    }

    public void setEntityList(List<CustomEntity> entityList) {
        this.entityList = entityList;
    }

    /***
     * EXAMPLE:
     * rewrite entityList according to searchCriteria
     * use in flows to evaluate
     * Example:
     *  <transition on="searchByTitle">
        <evaluate expression="entityFacade.getEntityByTitle()"/>
        </transition>
     */
    public void getMoviesByRegex(){
        entityList =  entityService.getEntityByRegex(searchCriteria.getSearchCriteria());
    }
    public void getMoviesByTitle(){
        entityList =  entityService.getEntityByTitle(searchCriteria.getSearchCriteria());
    }
    public void getMoviesByDescription(){
        entityList = entityService.getEntityByDescription(searchCriteria.getSearchCriteria());
    }
    //TODO

}
