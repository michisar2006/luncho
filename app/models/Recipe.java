package models;

import java.util.Set;
import java.util.HashSet;

public class Recipe {

    public Integer id;
    public String name;
    public String description;

    public Recipe(){}

    public Recipe(Integer id, String name, String description){
        this.id=id;
        this.name=name;
        this.description=description;
    }

    private static Set<Recipe> recipes;

    static{
        recipes = new HashSet<>();
        recipes.add(new Recipe(1, "Fried eggs", "put the eggs and wait until they get fried"));
        recipes.add(new Recipe(2, "Rice", "Put rice with water and wait until it boil"));
    }

    public static Set<Recipe> getAll(){
        return recipes;
    }

    public static Recipe getById(Integer id){
        for(Recipe recipe: recipes){
            if(id.equals(recipe.id)){
                return recipe;
            }
        }
        return null;
    }

    public static void add(Recipe recipe){
        recipes.add(recipe);
    }

    public static boolean remove(Recipe recipe){
        return recipes.remove(recipe);
    }
}
