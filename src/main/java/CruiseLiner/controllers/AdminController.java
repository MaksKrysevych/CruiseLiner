package CruiseLiner.controllers;

import CruiseLiner.dao.CruiseDAO;
import CruiseLiner.dao.LinerDAO;
import CruiseLiner.dao.UserRequestDAO;
import CruiseLiner.model.Cruise;
import CruiseLiner.model.Liner;
import CruiseLiner.model.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    @PostMapping("/requests")
    public String requestUpdatingStatus(@ModelAttribute UserRequest userRequest){
        UserRequestDAO.update(userRequest);

        return "redirect:/requests";
    }

    @GetMapping("/cruises/{pageNo}")
    public String cruiseTable(@PathVariable(value = "pageNo") int pageNo, Model model){
        int recordsPerPage = 2;

        int rows = CruiseDAO.read().size();
        int noOfPages = rows / recordsPerPage;

        if (rows % recordsPerPage != 0) {
            noOfPages++;
        }
        List<Cruise> cruises = CruiseDAO.getSomeCruises(pageNo, 2);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", noOfPages);
        model.addAttribute("totalItems", rows);
        model.addAttribute("cruises", cruises);

        return "cruises";
    }

    @GetMapping("/cruises/update")
    public String cruiseForm(@ModelAttribute Cruise cruise, Model model){
        model.addAttribute("cruise", cruise);
        return "updateCruise";
    }

    @PostMapping("/cruises/update")
    public String cruiseSubmit(@ModelAttribute Cruise cruise){
        CruiseDAO.update(cruise);
        return "redirect:/cruises";
    }

    @PostMapping("/cruises/delete")
    public String cruiseDelete(@ModelAttribute Cruise cruise){
        CruiseDAO.delete(cruise);

        return "redirect:/cruises";
    }

    @GetMapping("/cruises/createCruise")
    public String createCruiseForm(Model model){
        model.addAttribute("cruise", new Cruise());
        return "createCruise";
    }

    @PostMapping("/cruises/createCruise")
    public String createCruiseSubmit(@ModelAttribute Cruise cruise){
        CruiseDAO.create(cruise);
        return "redirect:/cruises";
    }

    @GetMapping("/liners/{pageNo}")
    public String linerTable(@PathVariable(value = "pageNo") int pageNo, Model model){

        int recordsPerPage = 2;

        int rows = LinerDAO.read().size();
        int noOfPages = rows / recordsPerPage;

        if (rows % recordsPerPage != 0) {
            noOfPages++;
        }
        List<Liner> liners = LinerDAO.getSomeLiners(pageNo, 2);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", noOfPages);
        model.addAttribute("totalItems", rows);
        model.addAttribute("liners", liners);
        return "liners";
    }

    @GetMapping("/liners/update")
    public String linerForm(@ModelAttribute Liner liner, Model model){
        model.addAttribute("liner", liner);
        return "updateLiner";
    }

    @PostMapping("/liners/update")
    public String linerSubmit(@ModelAttribute Liner liner){

        LinerDAO.update(liner);
        return "redirect:/liners";
    }

    @PostMapping("/liners/delete")
    public String linerDelete(@ModelAttribute Liner liner){
        LinerDAO.delete(liner);
        return "redirect:/liners";
    }

    @GetMapping("/liners/createLiner")
    public String createLinerForm(Model model){
        model.addAttribute("liner", new Liner());
        return "createLiner";
    }

    @PostMapping("/liners/createLiner")
    public String createLinerSubmit(@ModelAttribute Liner liner){
        LinerDAO.create(liner);
        return "redirect:/liners";
    }
}
