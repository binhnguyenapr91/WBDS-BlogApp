package controller;

import javafx.geometry.Pos;
import model.Category;
import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CategoryService;
import service.PostService;

@Controller
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
    ModelAndView getAllPost() {
        ModelAndView modelAndView = new ModelAndView("listing");
        Iterable<Post> posts = postService.findAll();
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    ModelAndView viewPost(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        Post post = postService.findById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    ModelAndView deletePost(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("listing");
        postService.remove(id);
        Iterable<Post> posts = postService.findAll();
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
