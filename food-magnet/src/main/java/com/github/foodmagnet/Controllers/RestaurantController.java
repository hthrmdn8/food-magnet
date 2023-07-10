package com.github.foodmagnet.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("restaurant")
public class RestaurantController {

    @GetMapping("")
    public String index(){
        return "restaurant";
    }
}