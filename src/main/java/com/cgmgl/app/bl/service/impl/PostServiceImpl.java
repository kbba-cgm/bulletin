package com.cgmgl.app.bl.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgmgl.app.bl.dto.PostDto;
import com.cgmgl.app.bl.service.PostService;
import com.cgmgl.app.persistence.dao.PostDao;
import com.cgmgl.app.persistence.entity.Post;
import com.cgmgl.app.persistence.entity.User;

@Service
public class PostServiceImpl implements PostService {
	private Timestamp now;
	
	@Autowired
	private PostDao postDao;
	
	public List<Post> getAllPost() {
		return postDao.getAllPost();
	}
	
	public List<PostDto> getPublicPost() {
		List<PostDto> list = new ArrayList<>();
		ArrayList<Post> postList = (ArrayList<Post>) postDao.getPublicPost();
		
		for (Post post : postList) {
			list.add(new PostDto(post));
		}
		
		return list;
	}
	
	public List<Post> getOwnPost(long id) {
		return postDao.getOwnPost(id);
	}

	public PostDto getPostById(long id) {
		return new PostDto(postDao.getPostById(id));
	}

	public long createPost(PostDto postDto) {
		now  = new Timestamp(new Date().getTime());
		postDto.setCreated_at(now);
		postDto.setUpdated_at(now);
		return postDao.createPost(getPostData(postDto));
	}

	public void updatePost(PostDto postDto) {
		now  = new Timestamp(new Date().getTime());
		postDto.setUpdated_at(now);
		postDao.updatePost(getPostData(postDto));
	}

	public void deletePost(PostDto postDto) {
		postDao.deletePost(getPostData(postDto));
	}

	public void deletePostById(long id) {
		deletePost(getPostById(id));
	}
	
	public Post getPostData(PostDto postDto) {
		Post post = new Post();
		post.setId(postDto.getId());
		post.setContent(postDto.getContent());
		post.setTitle(postDto.getTitle());
		post.setIs_published(postDto.isIs_published());
		post.setUser(new User(postDto.getUserDto()));
		post.setCategories(postDto.getCategories()); 
		post.setCreated_at(postDto.getCreated_at());
		post.setUpdated_at(postDto.getUpdated_at());

		return post;
	}

}
