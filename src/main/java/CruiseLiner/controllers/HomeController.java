package CruiseLiner.controllers;

import CruiseLiner.dao.CruiseDAO;
import CruiseLiner.model.Cruise;
import CruiseLiner.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String cruiseLiner(){
        return "cruiseLiner";
    }

    @GetMapping("/contacts")
    public String contacts(){
        return "contacts";
    }

    @GetMapping("/catalog")
    public  String catalog(Model model){
        List<Cruise> cruises = CruiseDAO.read();
        model.addAttribute("cruises", cruises);
        return "catalog";
    }

    @GetMapping("/{name}")
    public String details(@PathVariable("name") String name, Model model){
        model.addAttribute("cruise", CruiseDAO.findCruiseByName(name));
        return "details";
    }

}
