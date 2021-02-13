package guru.springframework.domain;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "categories", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Recipe> recipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
