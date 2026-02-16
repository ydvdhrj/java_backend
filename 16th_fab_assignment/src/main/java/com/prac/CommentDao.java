package com.prac;

import javax.persistence.*;
import java.util.List;

public class CommentDao {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    // Add Comment
    public void addComment(Comment comment) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(comment);
        em.getTransaction().commit();

        em.close();
    }

    // Fetch comments by post
    public List<Comment> getCommentsByPost(int postId) {

        EntityManager em = emf.createEntityManager();

        List<Comment> comments = em.createQuery(
                "SELECT c FROM Comment c WHERE c.post.id = :pid",
                Comment.class)
                .setParameter("pid", postId)
                .getResultList();

        em.close();
        return comments;
    }

    // Fetch comments by user
    public List<Comment> getCommentsByUser(int userId) {

        EntityManager em = emf.createEntityManager();

        List<Comment> comments = em.createQuery(
                "SELECT c FROM Comment c WHERE c.user.id = :uid",
                Comment.class)
                .setParameter("uid", userId)
                .getResultList();

        em.close();
        return comments;
    }
}
