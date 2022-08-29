package com.cgmgl.app.bl.dto;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.cgmgl.app.persistence.entity.Category;
import com.cgmgl.app.persistence.entity.Post;

public class CategoryDto {
	private long id;

	@Length(max = 255, message = "Category name must not more than 255 characters.")
	@NotEmpty(message = "Category name must not be empty.")
	private String name;

	private List<Post> posts;

	private Timestamp created_at;

	private Timestamp updated_at;

	public CategoryDto() {
		
	}
	
	public CategoryDto(Category category) {
		if (category == null) {
			category = new Category();
		}
		id = category.getId();
		name = category.getName();
		posts = category.getPosts();
		created_at = category.getCreated_at();
		updated_at = category.getUpdated_at();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
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
		if (!(obj instanceof CategoryDto)) {
			return false;
		}
		CategoryDto other = (CategoryDto) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	
}
