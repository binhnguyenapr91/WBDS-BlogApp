package repository;

import model.Category;
import model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post,Long> {
    Iterable<Post> findByCategory(Category category);
}
