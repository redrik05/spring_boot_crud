package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    public UserService us;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", us.getAllUsers());
        return "users";
    }

    @GetMapping("/id")
    public String getUserById(@RequestParam("id") long id, Model model){
        model.addAttribute("user", us.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        us.addUser(user);
        return "redirect:/users";
    }

    public void deleteUser(){

    }

    @GetMapping("/id/edit")
    public String edit(Model model, @RequestParam("id") long id) {
        model.addAttribute("user", us.getUserById(id));
        return "edit";
    }

    @PatchMapping("/id")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("id") long id) {
        us.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/id")
    public String deleteUser(@RequestParam("id") Long id) {
        us.deleteUser(id);
        return "redirect:/users";
    }


}
