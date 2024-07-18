package kr.re.kitri.springposts.service;

import kr.re.kitri.springposts.model.Post;
import kr.re.kitri.springposts.repository.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostService postService;

    @Test
    public void viewAllPost(){
        // viewAllPosts 함수를 먼저 실행
        // 성공적으로 실행되면 테스트 통과,잘못 실행되거나 에러나면 실패
        // 조회해서 글의 갯수가 1개 이상이면 통과
        Iterable<Post> posts = postService.viewAllPosts();
        Assertions.assertTrue(posts.iterator().hasNext());

    }

    @Test
    public void viewPostById(){
        // viewPostById를 실행
        // id값은 2로 한다.
        // Post객체의 id=2면 통과
        Post post = postService.viewPostById(2);
        Assertions.assertEquals(2, post.getId());
    }

    @Test
    @Transactional
    public void registerPost(){
        //title="test", body="게시글 등록 테스트", likes=0
        //id는 자동설정
        //반환된 Post의 title이 "test"인지 확인하여 맞으면 통과
        Post testPost = new Post("test","게시글 등록 테스트",0);
        Post post = postService.registerPost(testPost);
        Assertions.assertEquals("test",post.getTitle());
    }

    @Test
    @Transactional
    public void updateLikesPlusOne(){
        // 2번 아이디의 포스트에 좋아요를 수행한다.
        // 에러가 안나면 성공한 것.(성공적으로 DB접근 후 업데이트 했다는 의미)
        postService.updateLikesPlusOne(2);
    }

}
