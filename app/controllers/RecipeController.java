package controllers;

import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import models.Recipe;
import views.html.recipes.*;

import javax.inject.Inject;
import java.util.Set;

public class RecipeController extends Controller {

    @Inject
    FormFactory formFactory;

    public Result index(){
        Set<Recipe> recipes = Recipe.getAll();
        return ok(index.render(recipes));
    }

    public Result show(Integer id) {
        Recipe recipe = Recipe.getById(id);
        if(recipe==null){
            return notFound("Book not found");
        }
        return ok(show.render(recipe));
    }

    public Result create(){
        Form<Recipe> recipeForm = formFactory.form(Recipe.class);
        return ok(create.render(recipeForm));
    }

    //GET edit
    public Result edit(Integer id){
        Recipe recipe = Recipe.getById(id);

        if(recipe==null){
            return notFound("Recipe not found");
        }

        Form<Recipe> bookForm = formFactory.form(Recipe.class).fill(recipe);
        return ok(edit.render(bookForm));

    }

    //POST edit
    public Result update(){
        Recipe recipe = formFactory.form(Recipe.class).bindFromRequest().get();
        Recipe oldRecipe = Recipe.getById(recipe.getId());

        if(oldRecipe == null){
            return notFound("Recipe not found");
        }

        oldRecipe.setName(recipe.getName());
        oldRecipe.setDescription(recipe.getDescription());


        return redirect(routes.RecipeController.index());
    }


    public Result save(){
        DynamicForm requestData = formFactory.form().bindFromRequest();
        Recipe recipe = new Recipe(
                Integer.parseInt(requestData.get("id")),
                requestData.get("name"),
                requestData.get("description")
        );
        Recipe.add(recipe);

        return redirect(routes.RecipeController.index());
    }

    public Result destroy(Integer id){
        Recipe recipe = Recipe.getById(id);

        if (recipe==null){
            return notFound("The recipe does not found");
        }

        Recipe.remove(recipe);

        return redirect(routes.RecipeController.index());
    }

}
