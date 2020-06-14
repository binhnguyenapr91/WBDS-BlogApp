package service.impl;

import model.Category;
import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.PostRepository;
import service.PostService;

public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepository.delete(id);
    }

    @Override
    public Iterable<Post> findByCategory(Category category) {
        return postRepository.findByCategory(category);
    }

    @Override
    public Page<Post> findAllByDescriptionContaining(String searchContent, Pageable pageable) {
        return postRepository.findAllByDescriptionContaining(searchContent,pageable);
    }

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }
}
