package kr.re.kitri.springposts.controller;

import kr.re.kitri.springposts.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String allPosts(){
        return postService.viewAllPosts();
    }
}
