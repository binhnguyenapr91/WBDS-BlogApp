package repository.impl;

import model.Post;
import repository.PostRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PostRepositoryImpl implements PostRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Post> findAll() {
        TypedQuery<Post> query = em.createQuery("select c from Post c",Post.class);
        return query.getResultList();
    }

    @Override
    public Post findById(Long id) {
        TypedQuery<Post> query = em.createQuery("select c from Post c where c.id =: id",Post.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Post model) {
        if (model.getId()!=null){
            em.merge(model);
        }else em.persist(model);
    }

    @Override
    public void remove(Long id) {
        Post post = findById(id);
        if(post!=null){
            em.remove(post);
        }
    }
}
