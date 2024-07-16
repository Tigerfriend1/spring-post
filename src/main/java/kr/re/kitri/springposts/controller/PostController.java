package kr.re.kitri.springposts.controller;

import kr.re.kitri.springposts.model.Post;
import kr.re.kitri.springposts.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> allPosts(){
        return postService.viewAllPosts();
    }


    @GetMapping("/posts/{postId}")
    public Post viewPostById(@PathVariable long postId){
        System.out.println(postId);
        return postService.viewPostById(postId);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post){
        System.out.println(post);
        return postService.registerPost(post);

    }
}
