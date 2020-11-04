package HelloWorldBlog.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_SEQ")
    @SequenceGenerator(sequenceName = "post_seq", allocationSize = 1, name = "post_SEQ")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "descr")
    private String description;
    @Column(name = "text")
    private String text;

    public Post(){}

    public Post(String title, String description, String text) {
        this.title = title;
        this.description = description;
        this.text = text;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) &&
                Objects.equals(title, post.title) &&
                Objects.equals(description, post.description) &&
                Objects.equals(text, post.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, text);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
