package com.cgmgl.app.bl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cgmgl.app.bl.dto.PostDto;
import com.cgmgl.app.persistence.entity.Post;

@Service
public interface PostService {
	public List<Post> getAllPost();
	
	public List<Post> getPublicPost();

	public List<Post> getOwnPost(long id);
	
	public PostDto getPostById(long id);

	public long createPost(PostDto postDto);

	public void updatePost(PostDto postDto);

	public void deletePost(PostDto postDto);

	public void deletePostById(long id);
}
