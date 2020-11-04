package HelloWorldBlog.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "posts_authors")
public class PostsAuthors {
    @Id
    @Column(name = "pa_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_auth_SEQ")
    @SequenceGenerator(sequenceName = "posts_authors_seq", allocationSize = 1, name = "post_auth_SEQ")
    private Long id;
    @Column(name = "post_id")
    private Long postId;
    @Column(name = "author_id")
    private Long authorId;

    public PostsAuthors(){}

    public PostsAuthors(Long postId, Long authorId) {
        this.postId = postId;
        this.authorId = authorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostsAuthors that = (PostsAuthors) o;
        return id.equals(that.id) &&
                postId.equals(that.postId) &&
                authorId.equals(that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postId, authorId);
    }

    @Override
    public String toString() {
        return "PostsAuthors{" +
                "id=" + id +
                ", postId=" + postId +
                ", authorId=" + authorId +
                '}';
    }
}
