package kr.re.kitri.springposts.controller;

import kr.re.kitri.springposts.model.Post;
import kr.re.kitri.springposts.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<Iterable<Post>> allPosts(){
        return ResponseEntity.ok().body(postService.viewAllPosts());
    }


    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> viewPostById(@PathVariable long postId){
        return ResponseEntity.ok().body(postService.viewPostById(postId));
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        return ResponseEntity.status(201).body(postService.registerPost(post));
    }

    @PatchMapping("/posts/{postId}/likes")
    public ResponseEntity<String> doLike(@PathVariable long postId){
        postService.updateLikesPlusOne(postId);
        return ResponseEntity.ok().body("좋아요 반영 성공");
    }
}
