package service;

import model.Post;

public interface PostService {
    Iterable<Post> findAll();
    Post findById(Long id);
    void save(Post post);
    void remove(Long id);
}
