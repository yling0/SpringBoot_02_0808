package me.yling.helloworldproject.controllers;

import me.yling.helloworldproject.models.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class HomeController
{
    @RequestMapping("/")
    public String homePage(Model model)
    {
        model.addAttribute("myvar","Say hello to the people.");
        return "hometemplate";
    }

    @RequestMapping("/loadform")
    public String loadFormPage()
    {
        return "formtemplate";
    }

    @RequestMapping("/processform")
    public String loadFromPage(@RequestParam("login") String login, Model model)
    {
        model.addAttribute("loginval",login);
        return "confirm";
    }

    @RequestMapping("/songform")
    public String loadFormPage (Model model)
    {
        model.addAttribute("song",new Song());
        return "songform";
    }

    @PostMapping("/songform")
    public String loadFromPage(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult)
    {
        return "confirmsong";
    }


}


