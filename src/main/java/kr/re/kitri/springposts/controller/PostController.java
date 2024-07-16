package kr.re.kitri.springposts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @GetMapping
    public String allPosts(){
        return null;
    }
}
