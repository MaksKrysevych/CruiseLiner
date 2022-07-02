package CruiseLiner.controllers;

import CruiseLiner.dao.CruiseDAO;
import CruiseLiner.dao.LinerDAO;
import CruiseLiner.model.Cruise;
import CruiseLiner.model.Liner;
import CruiseLiner.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/catalog/{pageNo}")
    public  String catalog(@PathVariable(value = "pageNo") int pageNo, @RequestParam(value = "sorting") String sorting, Model model){
        int recordsPerPage = 2;
        int rows = CruiseDAO.read().size();
        int noOfPages = rows / recordsPerPage;

        if (rows % recordsPerPage != 0) {
            noOfPages++;
        }
        if (sorting.equals("standard")){
            List<Cruise> cruises = CruiseDAO.getSomeCruises(pageNo, 2);
            model.addAttribute("cruises", cruises);
        }
        else if (sorting.equals("byDate")){
            List<Cruise> cruises = CruiseDAO.getSomeCruisesByDate(pageNo, 2);
            model.addAttribute("cruises", cruises);
        }
        else if (sorting.equals("byDays")){
            List<Cruise> cruises = CruiseDAO.getSomeCruisesByDays(pageNo, 2);
            model.addAttribute("cruises", cruises);
        }


        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", noOfPages);
        model.addAttribute("totalItems", rows);
        model.addAttribute("sorting", sorting);

        return "catalog";
    }

    @GetMapping("/{name}")
    public String details(@PathVariable("name") String name, Model model){
        model.addAttribute("cruise", CruiseDAO.findCruiseByName(name));

        return "details";
    }

}
