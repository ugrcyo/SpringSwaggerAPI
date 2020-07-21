package com.ugrcyo.first.controller;

import com.ugrcyo.first.domain.post;
import com.ugrcyo.first.service.postservice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
@Api(value="post", description=" Post Operations Service")
public class postcontroller {
    @Autowired
    private postservice postservice;
    private static final Logger log = LoggerFactory.getLogger(postcontroller.class);

    @ApiOperation(value = "View a list of available posts",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )

    @GetMapping("/")
    public List<post> findAllUsers() {
        return postservice.getAll();
    }

    @ApiOperation(value = "Search a post with an ID",response = post.class)
    @GetMapping("/{id}")
    public post findPostById(@RequestBody long id) {
        return postservice.getPostbyId(id);
    }

    @ApiOperation(value = "Add a post")
    @PostMapping("/add")
    public post addPost(@RequestBody post posts){
        return postservice.savePost(posts);
    }

    @PostMapping("/adds")
    public List<post> addPosts(@RequestBody List<post> posts){
        return (List<post>) postservice.savePost((post) posts);
    }

    @ApiOperation(value = "Delete a post")
    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable long id) {
        return postservice.deletePost(id);
    }

    @ApiOperation(value = "Update a post")
    @PutMapping("/update/{id}")
    public post updatePost(@RequestBody post post)
    {return postservice.updatePost(post);}
}
