package service;

import model.Category;
import model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Page<Post> findAll(Pageable pageable);
    Post findById(Long id);
    void save(Post post);
    void remove(Long id);
    Iterable<Post> findByCategory(Category category);
    Page<Post> findAllByDescriptionContaining(String searchContent,Pageable pageable);
}
