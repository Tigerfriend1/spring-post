package kr.re.kitri.springposts.repository;

import kr.re.kitri.springposts.model.Post;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PostRepository {
    List<Post> selectAllPost() ;

    Post selectPostById(@Param("postId") long postId) ;

    Post insertPost(Post post) ;

    Post updateLikesPlusOne(@Param("postId")long postId);
}
