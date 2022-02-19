package org.launchecode.cheesemvc.controller;

import io.netty.handler.codec.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("cheese")
public class CheessController {

    static ArrayList<String> cheeses = new ArrayList<String>();

    @RequestMapping(value="")
    public String index(Model model) {

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheese");
        return "cheese/index";
    }

    @RequestMapping(value = "add" , method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model)
    {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add" , method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam(required=true ,name="cheeseName") String cheeseName)
    {
        cheeses.add(cheeseName);
        //add a comment here.
        return "redirect:";
    }
}
