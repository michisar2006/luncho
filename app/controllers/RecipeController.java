package controllers;

import play.mvc.*;

import views.html.recipes.*;

public class RecipeController extends Controller {

    public Result index(){
        return TODO;
    }

    public Result retrieve(Integer id) {
        return ok(recipe.render("hola"));
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
