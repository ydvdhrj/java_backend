package com.prac;

import javax.persistence.*;
import java.util.List;

public class PostDao {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    // Create Post
    public void createPost(Post post) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(post);
        em.getTransaction().commit();

        em.close();
    }

    // Update Post
    public void updatePost(Post post) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(post);
        em.getTransaction().commit();

        em.close();
    }

    // Delete Post
    public void deletePost(int postId) {

        EntityManager em = emf.createEntityManager();

        Post p = em.find(Post.class, postId);

        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();

        em.close();
    }

    // Fetch posts by user
    public List<Post> getPostsByUser(int userId) {

        EntityManager em = emf.createEntityManager();

        List<Post> posts = em.createQuery(
                "SELECT p FROM Post p WHERE p.user.id = :uid",
                Post.class)
                .setParameter("uid", userId)
                .getResultList();

        em.close();
        return posts;
    }
}
