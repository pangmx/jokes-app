package mx.collection.jokesapp.controller;

import mx.collection.jokesapp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {
    private JokeService jokeService;

    @Autowired
    public JokeController(JokeService jokeService){
        this.jokeService=jokeService;
    }

    @RequestMapping({"/",""})
    public String showJoke(Model model){

        // generate a new joke string with jokeService, then add in into Model
        model.addAttribute("joke",jokeService.getJoke());

        // return the next thymeleaf viewname
        return "chucknorris";
    }

}
