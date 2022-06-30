package CruiseLiner.controllers;

import CruiseLiner.dao.CruiseDAO;
import CruiseLiner.dao.LinerDAO;
import CruiseLiner.dao.UserDAO;
import CruiseLiner.dao.UserRequestDAO;
import CruiseLiner.model.Liner;
import CruiseLiner.model.User;
import CruiseLiner.model.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("user", new User());
        return "/login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user){
        User fullUser = UserDAO.findUserByLogin(user.getLogin());
        if (fullUser.getEmail() == null)
            return "login";
        else
            return "redirect:/";
    }

    @GetMapping("/signup")
    public String signupForm(Model model){
        model.addAttribute("user", new User());
        return "/signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute User user){
        user.setRole("user");
        user.setAccount(0);
        user.setNotification((byte) 0);
        UserDAO.create(user);
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    @GetMapping("/book/{cruiseName}")
    public String bookForm(@PathVariable("cruiseName") String cruiseName, String room, Model model){
        model.addAttribute("cruiseName", CruiseDAO.findCruiseByName(cruiseName).getName());
        model.addAttribute("room", room);
        model.addAttribute("userRequest", new UserRequest());
        return "book";
    }

    @PostMapping("/book/{cruiseName}")
    public String bookSubmit(@ModelAttribute String room, @ModelAttribute UserRequest userRequest, @PathVariable("cruiseName") String cruiseName){
        room = userRequest.getStatus();
        int price = 0;
        java.util.Date dateNow = new java.util.Date();
        String date = new SimpleDateFormat("yyyy-MM-dd").format(dateNow);

        if (room.equals("inner")){
            price = LinerDAO.findLinerByName(CruiseDAO.findCruiseByName(cruiseName).getLiner()).getRoomInner() * userRequest.getCountPeople();
        }
        else if (room.equals("with window")){
            price = LinerDAO.findLinerByName(CruiseDAO.findCruiseByName(cruiseName).getLiner()).getRoomWithWindow() * userRequest.getCountPeople();
        }
        else if (room.equals("with balcony")){

            price = LinerDAO.findLinerByName(CruiseDAO.findCruiseByName(cruiseName).getLiner()).getRoomWithBalcony() * userRequest.getCountPeople();
        }
        else if (room.equals("luxury")){
            price = LinerDAO.findLinerByName(CruiseDAO.findCruiseByName(cruiseName).getLiner()).getRoomLuxury() * userRequest.getCountPeople();
        }
        UserRequestDAO.create(new UserRequest(userRequest.getLogin(), cruiseName, price, Date.valueOf(date), userRequest.getCountPeople(), "created"));

        return "redirect:/";
    }

    @GetMapping("/requests")
    public String requestsTable(Model model){
        List<UserRequest> userRequests = UserRequestDAO.read();
        model.addAttribute("userRequests", userRequests);
        return "requests";
    }

    @PostMapping("/requests/delete")
    public String requestDelete(@ModelAttribute UserRequest userRequest){
        UserRequestDAO.delete(userRequest);

        return "redirect:/requests";
    }
}
