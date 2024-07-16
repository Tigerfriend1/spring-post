package kr.re.kitri.springposts.repository;

import kr.re.kitri.springposts.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    public List<Post> selectAllPost() {

        //db에서 3개 글을 가져와서 자바의 모델타입으로 변환하여 반환
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "first post","스프링 멋져요",0));
        posts.add(new Post(2, "second post","스프링 멋져요2",3));
        posts.add(new Post(3, "third post","스프링 멋져요3",9));
        return posts;
    }

    public Post selectPostById(long postId) {
        return new Post(postId,"해당 id값 제목","해당 본문",2);
    }

    public Post insertPost(Post post) {
        //insert into post values(post.getId(), post....);
        System.out.println("insert complete");
        return post;
    }

    public Post updateLikesPlusOne(long postId) {
        //postId에 해당하는 글에 likes를 1 증가시키는 쿼리
        //postId에 해당하는 글의 정보를 조회하는 쿼리
        return new Post(postId, "좋아요를 수정한 제목","본문내용",1); //db연동을 하지 않아서 임시.
    }
}
