package com.fastcampus.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fastcampus.domain.Post;
import com.fastcampus.persistence.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	@Transactional
	public void insertPost(Post post) {
		postRepository.save(post);
	}
	
	@Transactional
	public Page<Post> getPostList(Pageable pageable) {
		return postRepository.findAll(pageable);
	}
	
	@Transactional
	public Post getPost(int id) {
		return postRepository.findById(id).get();
	}
	
	@Transactional 
	public void updatePost(Post post) {
		Post findPost = postRepository.findById(post.getId()).get();
		
		findPost.setTitle(post.getTitle());
		findPost.setContent(post.getContent());
		postRepository.save(findPost);
	}
	
	@Transactional
	public void deletePost(int id) {
		postRepository.deleteById(id);
	}

	
}
