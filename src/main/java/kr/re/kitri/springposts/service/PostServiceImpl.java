package kr.re.kitri.springposts.service;

import kr.re.kitri.springposts.model.Post;
import kr.re.kitri.springposts.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //전체글 보기
    @Override
    public List<Post> viewAllPosts(){
        return postRepository.selectAllPost();
    }
    // 글 상세보기(id로 게시글 찾기)
    @Override
    public Post viewPostById(long postId){
        return postRepository.selectPostById(postId);
    }
    // 글 등록
    @Override
    public Post registerPost(Post post){
        return postRepository.insertPost(post);
    }
    //글 수정
    // 글 삭제
    // 좋아요
    @Override
    public Post updateLikesPlusOne(long postId){
        return postRepository.updateLikesPlusOne(postId);
    }

}
