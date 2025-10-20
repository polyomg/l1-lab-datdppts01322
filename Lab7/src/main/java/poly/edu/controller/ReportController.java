package poly.edu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.dao.ProductDAO;
import poly.edu.entity.Report;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    ProductDAO dao;

    @RequestMapping("/inventory-by-category")
    public String inventory(Model model) {
        List<Report> items = dao.getInventoryByCategory();
        model.addAttribute("items", items);
        return "report/inventory-by-category";
    }
}
