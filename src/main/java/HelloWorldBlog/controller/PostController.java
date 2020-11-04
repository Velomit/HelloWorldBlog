package HelloWorldBlog.controller;

import HelloWorldBlog.entity.Author;
import HelloWorldBlog.entity.Post;
import HelloWorldBlog.entity.PostsAuthors;
import HelloWorldBlog.repository.AuthorRepository;
import HelloWorldBlog.repository.PostRepository;
import HelloWorldBlog.repository.PostsAuthorsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository repository;
    private final AuthorRepository authorRepository;
    private final PostsAuthorsRepository postsAuthorsRepository;

    public PostController(PostRepository repository, AuthorRepository authorRepository, PostsAuthorsRepository postsAuthorsRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
        this.postsAuthorsRepository = postsAuthorsRepository;
    }

    @RequestMapping(value = "/list-posts", method = RequestMethod.GET)
    public String showPosts(ModelMap model) {
        model.put("posts", repository.findAll());
        return "list-posts";
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String showPost(@RequestParam int id, ModelMap model) {
        Post post = repository.findById(id);

        List<PostsAuthors> postsAuthors = postsAuthorsRepository.findByPostId(post.getId());
        List<Author> authors = new ArrayList<>();
        for (PostsAuthors pa : postsAuthors) {
            long auId = pa.getAuthorId();
            authors.add(authorRepository.findById(auId));
        }
        model.put("post", post);
        model.put("authors", authors);
        return "post";
    }

    @RequestMapping(value = "/delete-post", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam long id) {
        try {
            repository.deleteById(id);
        } catch (RuntimeException e) {
            System.out.println(e.toString());
        }
        return "redirect:/list-posts";
    }

    @RequestMapping(value = "/add-post", method = RequestMethod.GET)
    public String showAddPostPage(ModelMap model) {
        model.addAttribute("post", new Post("", "", ""));
        return "postInteraction";
    }

    @RequestMapping(value = "/add-post", method = RequestMethod.POST)
    public String addPost(ModelMap model, @Valid Post post, BindingResult result) {

        if (result.hasErrors()) {
            return "postInteraction";
        }
        repository.save(new Post(post.getTitle(), post.getDescription(), post.getText()));
        return "redirect:/list-posts";
    }

    @RequestMapping(value = "/update-post", method = RequestMethod.GET)
    public String showUpdatePostPage(@RequestParam int id, ModelMap model) {
        Post post = repository.findById(id);
        model.put("post", post);
        return "postInteraction";
    }

    @RequestMapping(value = "/update-post", method = RequestMethod.POST)
    public String updatePost(ModelMap model, @Valid Post post, BindingResult result) {

        if (result.hasErrors()) {
            return "postInteraction";
        }

        Post newPost = new Post(post.getTitle(), post.getDescription(), post.getText());
        newPost.setId(post.getId());
        repository.save(newPost);

        return "redirect:/list-posts";
    }


}
