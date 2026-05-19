package kg.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Setter
@Getter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)


@JsonIgnoreProperties(ignoreUnknown = true)
public class Post extends BaseModel{
    Integer id;
    Integer user_id;
    String title;
    String body;

//    "id": 276678,
//    "user_id": 8430242,
//    "title": "Sufficio unde pecus carcer crapula.",
//    "body":
}
