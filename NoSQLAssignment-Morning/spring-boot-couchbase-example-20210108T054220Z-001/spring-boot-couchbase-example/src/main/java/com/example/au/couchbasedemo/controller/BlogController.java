package com.example.au.couchbasedemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Blogs;
import com.example.au.couchbasedemo.repository.BlogRepository;

@RestController
public class BlogController {
    
    @Autowired
    BlogRepository blogRepository;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    @PostMapping("/blogs")
    public Blogs addBlogPost(@RequestBody Blogs newBlog) {
        return blogRepository.save(newBlog);
    }
    
    @GetMapping("/blogs/{id}")
    public Optional<Blogs> getBlog(@PathVariable String id) {
        if (blogRepository.existsById(id)) {
            return blogRepository.findById(id);
        } else
            return Optional.empty();
    }
    
    @GetMapping("/blogs/author/{author}")
    public Blogs getBlogByAuthorName(@PathVariable String author) {
        return blogRepository.findByAuthor(author);
    }
    
    
    @GetMapping("/blogs/tag/{tag}")
    public Blogs[] getBlogByTagName(@PathVariable String tag) {
    	Blogs[] response = blogRepository.findByTag1(tag) ;// blogRepository.findByTag2(tag);
    	if(response.length == 0) {
    		response = blogRepository.findByTag2(tag);
    		System.out.println("Tag 2");
    	}
    	if (response.length==0) {
    		System.out.println("Tag 3");
    		response = blogRepository.findByTag3(tag);
    	}
     	System.out.println(response.getClass().getName());
        return response;
  

    }
    
    @DeleteMapping("/blogs/topic/{topic}/author/{author}")
    public List<Blogs> deleteByAuthorAndTopic(@PathVariable String topic, @PathVariable String author) {
        return blogRepository.deleteBytopicAndAuthor(topic, author);
    }
    
    @DeleteMapping("/blogs/{id}")
    public void deleteById(@PathVariable String id) {
        blogRepository.deleteById(id);
    }
    
	/*
	 * @PutMapping("/blogs/{idToBeUpdated}") public String updateBlog(@PathVariable
	 * String idToBeUpdated, @RequestBody BlogsUpdateRequest blogsUpdateRequest) {
	 * 
	 * Optional<Blogs> mayBeBlog = blogRepository.findById(idToBeUpdated) .map(blogs
	 * –> blogRepository .save(Blogs .builder() .id(idToBeUpdated)
	 * .topic(blogsUpdateRequest.getTopic()) .tags(blogsUpdateRequest.getTags())
	 * .author(blogs.getAuthor()) .date(blogs.getDate()) .build()) ); if
	 * (mayBeBlog.isPresent()) { return "Blog Updated"; } else { return
	 * "Blog does not exist"; } }
	 */
}