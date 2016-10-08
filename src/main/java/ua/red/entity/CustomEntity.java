package ua.red.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Add you entity here, this code used as example
 * use application.properties for connection properties
 *
 */
@Document(collection = "collection")
public class CustomEntity {
    /**
     * EXAMPLE ENTITY
     */
    @Id
    private String id;
    private String title;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
