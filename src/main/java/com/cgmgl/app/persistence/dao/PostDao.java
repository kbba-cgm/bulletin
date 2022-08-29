package com.cgmgl.app.persistence.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgmgl.app.persistence.entity.Post;

@Repository
public interface PostDao {
	public List<Post> getAllPost();
	
	public List<Post> getPublicPost();
	
	public List<Post> getOwnPost(long id);
	
	public Post getPostById(long id);
	
	public long createPost(Post post);
	
	public void updatePost(Post post);
	
	public void deletePost(Post post);
	
	public void deletePostById(long id);
	
}
