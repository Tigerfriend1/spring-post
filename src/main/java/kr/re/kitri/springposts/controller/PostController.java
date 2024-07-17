package kr.re.kitri.springposts.controller;

import kr.re.kitri.springposts.model.Post;
import kr.re.kitri.springposts.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class PostController {
    //private static final Logger log= LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> allPosts(){
        log.debug("전체보기 Log");
        return postService.viewAllPosts();
    }


    @GetMapping("/posts/{postId}")
    public Post viewPostById(@PathVariable long postId){
        log.debug("상세보기 Log");
        return postService.viewPostById(postId);
    }

    @PostMapping("/posts")
    public String addPost(@RequestBody Post post){
        log.debug("새로운 글 추가 Log");
        postService.registerPost(post);
        return "글 등록 성공";

    }

    @PatchMapping("/posts/{postId}/likes")
    public String doLike(@PathVariable long postId){
        log.debug("좋아요 반영 Log");
        postService.updateLikesPlusOne(postId);
        return "좋아요 반영 성공";
    }
}
