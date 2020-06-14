package repository;

import model.Category;
import model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface PostRepository extends PagingAndSortingRepository<Post,Long> {
    Iterable<Post> findByCategory(Category category);
    Page<Post> findAllByDescriptionContaining(String searchContent, Pageable pageable);
}
