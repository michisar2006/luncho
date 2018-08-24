package controllers;

import play.mvc.*;

import models.Recipe;
import views.html.recipes.*;
import java.util.Set;

public class RecipeController extends Controller {

    public Result index(){
        Set<Recipe> recipes = Recipe.getAll();
        return ok(index.render(recipes));
    }

    public Result retrieve(Integer id) {
        return TODO;
    }

    public Result create(){
        return TODO;
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
