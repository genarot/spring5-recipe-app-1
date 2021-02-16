package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(mappedBy = "recipe")
    @OneToOne
    private Recipe recipe;

    @Column(name = "recipe_notes")
    @Lob
    private String recipeNotes;
}
