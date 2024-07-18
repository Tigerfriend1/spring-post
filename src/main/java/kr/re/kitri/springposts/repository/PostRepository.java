package kr.re.kitri.springposts.repository;

import kr.re.kitri.springposts.model.Post;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//@Mapper
public interface PostRepository extends CrudRepository<Post,Long> {
    @Modifying
    @Query("update post_k set likes=likes+1 where id=:postId")
    void increaseLikes(@Param("postId") long postId);
}
