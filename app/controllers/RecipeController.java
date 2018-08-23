package controllers;

import play.mvc.*;


public class RecipeController extends Controller {

    public Result retrieve(String uuid){
        return ok("The recipe of some fried eggs with bacon ");
    }

}
