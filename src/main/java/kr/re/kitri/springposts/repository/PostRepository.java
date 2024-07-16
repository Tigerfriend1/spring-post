package kr.re.kitri.springposts.repository;

import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {
    public String selectAllPost() {
        return "DB"
    }
}
