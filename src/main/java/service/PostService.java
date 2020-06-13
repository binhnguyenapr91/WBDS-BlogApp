package service;

import model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(Long id);
    void save(Post post);
    void remove(Long id);
}
