package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResultController {

    @RequestMapping("/a")
    public String a(Model model) {
        model.addAttribute("message", "I come from a");
        return "a";
    }

    @RequestMapping("/b")
    public String b(RedirectAttributes params) {
        params.addAttribute("message", "I come from b");
        return "redirect:/a";
    }

    @RequestMapping("/c")
    public String c(Model model) {
        model.addAttribute("message", "I come from c");
        return "a"; // luôn dùng chung a.html
    }

    @RequestMapping("/d")
    public String d(Model model) {
        model.addAttribute("message", "I come from d");
        return "a"; // sửa lại để dùng a.html thay vì in text
    }
}
