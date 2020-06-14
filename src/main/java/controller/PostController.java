package controller;

import javafx.geometry.Pos;
import model.Category;
import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CategoryService;
import service.PostService;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("")
    ModelAndView getAllPost(@RequestParam("searchContent") Optional<String> searchContent, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("listing");
        Page<Post> posts;
        if(searchContent.isPresent()){
            posts = postService.findAllByDescriptionContaining(searchContent.get(),pageable);
        }else{
            posts = postService.findAll(pageable);
        }
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }
    @RequestMapping(value = "/api/postListing", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> apiGetPosts(){
        Iterable<Post> posts = postService.findAll();
        if(posts==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    ModelAndView viewPost(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        Post post = postService.findById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @RequestMapping(value = "/api/viewPost/{id}")
    public ResponseEntity<Post> apiViewPost(@PathVariable("id") Long id){
        Post posts = postService.findById(id);
        if(posts == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } return new ResponseEntity<>(posts,HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    ModelAndView deletePost(@PathVariable("id") Long id,Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("listing");
        postService.remove(id);
        Page<Post> posts = postService.findAll(pageable);
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @GetMapping("/create")
    ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("current_post", new Post());
        return modelAndView;
    }

    @PostMapping("/create")
    ModelAndView createPost(@ModelAttribute("current_post") Post post) {
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("message", "Create post successfully!");
        return modelAndView;

    }

    @GetMapping("/update/{id}")
    ModelAndView showUpdateForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("current_post", postService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    ModelAndView updatePost(@ModelAttribute("current_post") Post post) {
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("post", post);
        modelAndView.addObject("message", "Update post successfully!");
        return modelAndView;

    }
}
