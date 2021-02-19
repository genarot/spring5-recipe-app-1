package guru.springframework.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"recipe"})
@ToString(exclude = {"recipe"})
public class Note {
    private String id;

    private Recipe recipe;

    private String recipeNotes;
}
