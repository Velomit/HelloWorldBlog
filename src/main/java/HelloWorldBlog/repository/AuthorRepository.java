package HelloWorldBlog.repository;


import HelloWorldBlog.entity.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findById(long id);

    List<Author> findByLastName(String lastName);

}
