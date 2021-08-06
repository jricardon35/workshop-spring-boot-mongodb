package com.ricardonunes.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardonunes.workshopmongo.domain.Post;
import com.ricardonunes.workshopmongo.repository.PostRepository;
import com.ricardonunes.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post FindById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}	
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
}
