package com.cgmgl.app.bl.dto;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.cgmgl.app.persistence.entity.Post;


public class PostDto {
	private long id;

	@NotEmpty(message = "Title must not be empty.")
	private String title;

	@NotEmpty(message = "Content must not be empty.")
	private String content;

	private boolean is_published = false;
	
	/* private List<String> categories; */

	private Timestamp created_at;

	private Timestamp updated_at;

	public PostDto() {
		super();
	}

	public PostDto(Post post){
		if (post == null) {
			post = new Post();
		}
		id = post.getId();
		title = post.getTitle();
		content = post.getContent();
		is_published = post.isIs_published();
		/* categories = post.getCategories(); */
		created_at = post.getCreated_at();
		updated_at = post.getUpdated_at();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isIs_published() {
		return is_published;
	}

	public void setIs_published(boolean is_published) {
		this.is_published = is_published;
	}

	/*
	 * public List<String> getCategories() { return categories; }
	 * 
	 * public void setCategories(List<String> categories) { this.categories =
	 * categories; }
	 */

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

}
