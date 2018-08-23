package controllers;

import play.mvc.*;

import views.html.recipes.*;

public class RecipeController extends Controller {

    public Result retrieve(String id) {
        return ok(recipe.render(id));
    }
}
