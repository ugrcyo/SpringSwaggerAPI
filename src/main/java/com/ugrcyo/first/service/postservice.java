package com.ugrcyo.first.service;

import com.ugrcyo.first.domain.post;
import com.ugrcyo.first.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class postservice {
    @Autowired
    private PostRepository postRepository;

    public List<post> getAll(){
    return (List<post>) postRepository.findAll();
    }

    public post getPostbyId(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public post savePost(post post) {
        return postRepository.save(post);
    }

    public List<post> savePosts(List<post> posts){
        return (List<post>) postRepository.saveAll(posts);
    }


    public String deletePost(Long id) {
        postRepository.deleteById(id);
        return "User removed..."+id;
    }

    public post updatePost(post post) {
        post existingPost = postRepository.findById(post.getId()).orElse(null);
        existingPost.setTitle(post.getTitle());
        existingPost.setText(post.getText());
        return postRepository.save(existingPost);
    }
}
