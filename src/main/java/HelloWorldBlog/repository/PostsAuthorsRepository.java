package HelloWorldBlog.repository;


import HelloWorldBlog.entity.PostsAuthors;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostsAuthorsRepository extends CrudRepository<PostsAuthors, Long> {
    PostsAuthors findByAuthorId(Long authorId);
    List <PostsAuthors> findByPostId(Long postId);
}
