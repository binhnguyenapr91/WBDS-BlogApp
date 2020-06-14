package service.impl;

import model.Category;
import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import repository.PostRepository;
import service.PostService;

public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
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
}
