package com.cgmgl.app.bl.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.cgmgl.app.persistence.entity.Category;
import com.cgmgl.app.persistence.entity.Post;

public class PostDto {
	private long id;

	@NotEmpty(message = "Title must not be empty.")
	private String title;

	@NotEmpty(message = "Content must not be empty.")
	private String content;

	private boolean is_published = false;

	@Valid
	private List<Category> categories = new ArrayList<Category>();
	
	@Valid
	private UserDto userDto;

	private Timestamp created_at;

	private Timestamp updated_at;
	
	private long[] categories_id;

	public PostDto() {
		super();
	}

	public PostDto(Post post) {
		if (post == null) {
			post = new Post();
		}
		id = post.getId();
		title = post.getTitle();
		content = post.getContent();
		is_published = post.isIs_published();
		userDto = new UserDto(post.getUser());
		categories = post.getCategories();
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

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

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

	public long[] getCategories_id() {
		return categories_id;
	}

	public void setCategories_id(long[] categories_id) {
		this.categories_id = categories_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PostDto)) {
			return false;
		}
		PostDto other = (PostDto) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PostDto [id=" + id + ", title=" + title + ", content=" + content + ", is_published=" + is_published
				+ ", categories=" + categories + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ ", categories_id=" + Arrays.toString(categories_id) + "]";
	}

}
