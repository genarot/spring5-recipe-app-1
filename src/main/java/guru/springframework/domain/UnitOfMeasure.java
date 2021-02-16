package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;
}
