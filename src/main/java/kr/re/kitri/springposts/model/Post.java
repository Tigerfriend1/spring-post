package kr.re.kitri.springposts.model;

import lombok.*;

@Data//getter,setter,toString,hashCode 등
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private long id;
    private String title;
    private String body;
    private int likes;

}
