package CruiseLiner.controllers;

import CruiseLiner.dao.CruiseDAO;
import CruiseLiner.model.Cruise;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            List<Cruise> cruises = CruiseDAO.getSomeCruises(pageNo, recordsPerPage);
            model.addAttribute("cruises", cruises);
        }
        else if (sorting.equals("byDate")){
            List<Cruise> cruises = CruiseDAO.getSomeCruisesByDate(pageNo, recordsPerPage);
            model.addAttribute("cruises", cruises);
        }
        else if (sorting.equals("byDays")){
            List<Cruise> cruises = CruiseDAO.getSomeCruisesByDays(pageNo, recordsPerPage);
            model.addAttribute("cruises", cruises);
        }

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", noOfPages);
        model.addAttribute("totalItems", rows);
        model.addAttribute("sorting", sorting);

        return "catalog";
    }

    @GetMapping("/details/{name}")
    public String details(@PathVariable("name") String name, Model model){
        model.addAttribute("cruise", CruiseDAO.findCruiseByName(name));

        return "details";
    }

}
