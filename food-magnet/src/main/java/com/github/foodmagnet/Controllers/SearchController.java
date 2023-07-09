package com.github.foodmagnet.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "search")
public class SearchController {

    @GetMapping
    public String displaySearchPage(Model model) {

        return "search";
    }

}
