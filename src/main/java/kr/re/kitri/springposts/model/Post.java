package kr.re.kitri.springposts.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data//getter,setter,toString,hashCode 등
@NoArgsConstructor
@AllArgsConstructor
@Table(name="post_k")
public class Post {
    @Id
    private long id;
    private String title;
    private String body;
    private int likes;

}
