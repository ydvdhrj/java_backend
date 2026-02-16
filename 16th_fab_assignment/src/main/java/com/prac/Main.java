package com.prac;

public class Main {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        PostDao postDao = new PostDao();
        CommentDao commentDao = new CommentDao();

        // Register User
        User user = new User();
        user.setName("Dheeraj");
        user.setEmail("dheeraj@gmail.com");
        user.setPassword(1234);

        userDao.registerUser(user);

        // Create Post
        Post post = new Post();
        post.setTitle("My First Post");
        post.setContent("Hello Hibernate JPA");
        post.setCreated_at("2026-01-01");
        post.setUser(user);

        postDao.createPost(post);

        // Add Comment
        Comment comment = new Comment();
        comment.setContent("Nice post!");
        comment.setCreated_at("2026-01-01");
        comment.setUser(user);
        comment.setPost(post);

        commentDao.addComment(comment);

        System.out.println("All operations completed successfully!");
    }
}
