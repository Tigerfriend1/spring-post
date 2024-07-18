package kr.re.kitri.springposts.service;

import kr.re.kitri.springposts.model.Post;

public interface PostService {
    //전체글 보기
    Iterable<Post> viewAllPosts();

    // 글 상세보기(id로 게시글 찾기)
    Post viewPostById(long postId);

    // 글 등록
    Post registerPost(Post post);

    // 좋아요
    void updateLikesPlusOne(long postId);
}
