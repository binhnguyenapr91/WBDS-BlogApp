package controller;

import model.Category;
import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CategoryService;
import service.PostService;


@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    PostService postService;

    @GetMapping("")
    ModelAndView getAllCategory() {
        ModelAndView modelAndView = new ModelAndView("cateListing");
        Iterable<Category> categories = categoryService.findAll();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/create")
    ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("cateCreate");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    ModelAndView create(@ModelAttribute("category") Category category) {
        ModelAndView modelAndView = new ModelAndView("cateCreate");
        categoryService.save(category);
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "Create category successfully!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    ModelAndView delete(@PathVariable("id") Long id) {
        categoryService.remove(id);
        ModelAndView modelAndView = new ModelAndView("cateListing");
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    ModelAndView showUpdateForm(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = new ModelAndView("cateUpdate");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @PostMapping("/update")
    ModelAndView update(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("cateUpdate");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Update category successfully!");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    ModelAndView viewCategory(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);
        Iterable<Post> posts = postService.findByCategory(category);
        ModelAndView modelAndView = new ModelAndView("cateDetail");
        modelAndView.addObject("category", category);
        modelAndView.addObject("posts", posts);
        return modelAndView;

    }

    //API
    @RequestMapping(value = "/api/PostInCategory/{id}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Post>> apiGetPostInCategory(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);
        Iterable<Post> posts = postService.findByCategory(category);
        if (posts == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/categoryListing", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Category>> apiGetCategory() {
        Iterable<Category> categories = categoryService.findAll();
        if (categories == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);

    }
}
