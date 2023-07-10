package com.github.foodmagnet.Controllers;

import com.github.foodmagnet.models.data.RestaurantData;
import com.github.foodmagnet.models.restaurantmodels.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping(value = "search")
public class SearchController {

    @GetMapping
    public String displaySearchPage(Model model) throws IOException, InterruptedException, IllegalAccessException {

        HashMap<String, HashMap<String, Object>> fieldMap = new HashMap<>();
        for (Restaurant restaurant : RestaurantData.returnRestaurantData()) {
            fieldMap.put(restaurant.getName(), restaurant.getAllFields());
        }
        model.addAttribute("fieldMap", fieldMap);
        model.addAttribute("restaurants", RestaurantData.returnRestaurantData());
        return "search";
    }

}
