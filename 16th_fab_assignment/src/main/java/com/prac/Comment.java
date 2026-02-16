package com.prac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {

	@Id
	private int id;
	private String content;
	private String created_at;
	@ManyToOne
	private User user;
	@ManyToOne
	private Post post;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
}
