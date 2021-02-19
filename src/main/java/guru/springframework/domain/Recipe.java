package guru.springframework.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Recipe {
    private String id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    private String directions;

    private Difficulty difficulty;

    private Byte[] image;

    private Set<Ingredient> ingredients = new HashSet<>();

    private Note note;

    private Set<Category> categories = new HashSet<>();


    public void setNote(Note note) {
        this.note = note;
        if (note != null) {
            note.setRecipe(this);
        }
    }

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", prepTime=" + prepTime +
                ", cookTime=" + cookTime +
                ", servings=" + servings +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", directions='" + directions + '\'' +
                ", difficulty=" + difficulty +
                '}';
    }
}
