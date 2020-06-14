package formatter;

import model.Category;
import org.springframework.format.Formatter;
import service.CategoryService;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {
    private CategoryService categoryService;

    public CategoryFormatter(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        return categoryService.findById(Long.valueOf(text));
    }

    @Override
    public String print(Category object, Locale locale) {
        return object.toString();
    }
}
