package io.github.yunu7067.hibernatesearchdemo.post;

import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import javax.persistence.*;

@Table(name = "post")
@Entity
@Indexed
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @FullTextField
    @Column(name = "title", nullable = false)
    private String title;

    @FullTextField
    @Column(name = "content", nullable = false)
    private String content;


    public Post() {
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}