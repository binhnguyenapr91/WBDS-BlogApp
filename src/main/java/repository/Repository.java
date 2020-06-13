package repository;

import model.Post;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
    Post findById(Long id);
    void save(T model);
    void remove(Long id);
}
