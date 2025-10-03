package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.model.Product;

import java.util.*;

@Controller
public class ProductController {
    private List<Product> items = new ArrayList<>(Arrays.asList(
            new Product("A", 1.0),
            new Product("B", 12.0)
    ));

    /*?1*/
    @GetMapping("/product/form")
    public String form(Model model) {
        Product p = new Product("iPhone 30", 5000.0);
        model.addAttribute("p1", p);
        model.addAttribute("p2", new Product()); 
        return "product/form";
    }

    /*?2*/
    @PostMapping("/product/save")
    public String save(@ModelAttribute("p2") Product p, Model model) {
        items.add(p);
        model.addAttribute("p1", new Product("iPhone 30", 5000.0));
        return "product/form";
    }

    /*?3*/
    @ModelAttribute("items")
    public List<Product> getItems() {
        return items;
    }
}
