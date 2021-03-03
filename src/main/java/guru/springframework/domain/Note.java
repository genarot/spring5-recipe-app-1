package guru.springframework.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Note {
    @Id
    private String id;

    private String recipeNotes;
}
