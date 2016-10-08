package ua.red.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * class-container, contains string criteria that can be define from JSF pages, as singleton to remember its state
 *
 */
@Component
@Scope("singleton")
public class SearchCriteria {
    private String searchCriteria;

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
}
