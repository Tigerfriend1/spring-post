package kr.re.kitri.springposts.controller;

import kr.re.kitri.springposts.model.Post;
import kr.re.kitri.springposts.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<Iterable<Post>> allPosts(){
        log.debug("전체보기 Log");
        return ResponseEntity.ok().body(postService.viewAllPosts());
        //return postService.viewAllPosts();
    }


    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> viewPostById(@PathVariable long postId){
        log.debug("상세보기 Log");
        return ResponseEntity.ok().body(postService.viewPostById(postId));
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        log.debug("새로운 글 추가 Log");
        return ResponseEntity.status(201).body(postService.registerPost(post));
    }

    @PatchMapping("/posts/{postId}/likes")
    public ResponseEntity<String> doLike(@PathVariable long postId){
        log.debug("좋아요 반영 Log");
        postService.updateLikesPlusOne(postId);
        return ResponseEntity.ok().body("좋아요 반영 성공");
    }
}
