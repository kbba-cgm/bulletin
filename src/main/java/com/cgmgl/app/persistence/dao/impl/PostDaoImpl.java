package com.cgmgl.app.persistence.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgmgl.app.persistence.dao.AbstractDao;
import com.cgmgl.app.persistence.dao.PostDao;
import com.cgmgl.app.persistence.entity.Post;

@Transactional
@Repository
public class PostDaoImpl extends AbstractDao<Long, Post> implements PostDao {

	public List<Post> getAllPost() {
		return createQuery("from Post").getResultList();
	}
	
	public List<Post> getPublicPost() {
		return createQuery("from Post where is_published=true").getResultList();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Post> getOwnPost(long id) {
		Query query = getSession().createQuery("from Post p WHERE p.user.id = :id");
		query.setParameter("id", id);
		return (List<Post>) query.getResultList();
	}

	public Post getPostById(long id) {
		return getById(id);
	}

	public long createPost(Post post) {
		return (Long) create(post);
	}

	public void updatePost(Post post) {
		update(post);
	}

	public void deletePost(Post post) {
		delete(post);
	}

	public void deletePostById(long id) {
		deleteById(id);
	}

}
