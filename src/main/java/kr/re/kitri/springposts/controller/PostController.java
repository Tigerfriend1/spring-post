package kr.re.kitri.springposts.controller;

import kr.re.kitri.springposts.model.Post;
import kr.re.kitri.springposts.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    public Iterable<Post> allPosts(){
        log.debug("전체보기 Log");
        return postService.viewAllPosts();
    }


    @GetMapping("/posts/{postId}")
    public Post viewPostById(@PathVariable long postId){
        log.debug("상세보기 Log");
        return postService.viewPostById(postId);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post){
        log.debug("새로운 글 추가 Log");
        return postService.registerPost(post);
    }

    @PatchMapping("/posts/{postId}/likes")
    public String doLike(@PathVariable long postId){
        log.debug("좋아요 반영 Log");
        //postService.updateLikesPlusOne(postId);
        return "좋아요 반영 성공";
    }
}
