package kr.re.kitri.springposts.service;

import kr.re.kitri.springposts.model.Post;
import kr.re.kitri.springposts.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;


    //전체글 보기
    @Override
    public Iterable<Post> viewAllPosts(){
        return postRepository.findAll();
    }
    // 글 상세보기(id로 게시글 찾기)
    @Override
    public Post viewPostById(long postId){
        Optional<Post> post = postRepository.findById(postId);
        return post.orElse(null);
    }
    // 글 등록
    @Override
    public Post registerPost(Post post){
        return postRepository.save(post);
    }
    //글 수정
    // 글 삭제
    // 좋아요
    @Override
    public void updateLikesPlusOne(long postId){
        //postRepository.updateLikesPlusOne(postId);
    }

}
