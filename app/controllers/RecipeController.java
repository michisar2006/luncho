package controllers;

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
        return TODO;
    }

    //POST edit
    public Result update(){
        return TODO;
    }


    public Result save(){

        return TODO;
    }

    public Result destroy(Integer id){
        return TODO;
    }

}
