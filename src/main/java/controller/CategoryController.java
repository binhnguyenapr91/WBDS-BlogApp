package controller;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

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
        modelAndView.addObject("category",category);
        modelAndView.addObject("message","Update category successfully!");
        return modelAndView;
    }
}
