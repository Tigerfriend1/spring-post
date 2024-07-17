package kr.re.kitri.springposts.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data//getter,setter,toString,hashCode 등
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    private long id;
    private String title;
    private String body;
    private int likes;

}
