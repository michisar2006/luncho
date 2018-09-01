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

    public Result retrieve(Integer id) {
        return TODO;
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
        return TODO;
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
        return TODO;
    }

}
