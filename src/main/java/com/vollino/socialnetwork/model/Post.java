package com.vollino.socialnetwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.Objects;

/**
 * @author Bruno Vollino
 */
@Entity
public class Post {

    @Id
    private Long id;

    @ManyToOne(optional = false)
    private User user;

    @Column(nullable = false)
    private Date creationDate;

    @Column(nullable = false)
    private String text;

    public Post(Long id, User user, Date creationDate, String text) {
        this.id = id;
        this.user = user;
        this.creationDate = creationDate;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(getId(), post.getId()) &&
                Objects.equals(getUser(), post.getUser()) &&
                Objects.equals(getCreationDate(), post.getCreationDate()) &&
                Objects.equals(getText(), post.getText());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getUser(), getCreationDate(), getText());
    }
}
