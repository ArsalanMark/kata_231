package web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String mainPage(Model model) {
        List<User> users = userService.userList();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping(value="/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        return "save-user";
    }
    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }
    @PostMapping("/save")
    public String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "save-user";
    }
    @PostMapping("/delete")
    public String editUser(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
