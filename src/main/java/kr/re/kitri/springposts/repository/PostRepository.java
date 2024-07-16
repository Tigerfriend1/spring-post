package kr.re.kitri.springposts.repository;

import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {
    public String selectAllPost() {
        return "DB에서 가져온 글 데이터";
    }
}
