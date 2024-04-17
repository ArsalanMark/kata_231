package web.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/users")
    public String mainPage(Model model) {
        List<User> users = userService.userList();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping(value="/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        System.out.println("addUser");
        return "add-user";
    }
    @PostMapping("/save")
    public String create(@ModelAttribute("user") User user) {
        System.out.println("Post controller" + user);
        userService.add(user);
        return "redirect:/users";
    }
    @PostMapping("/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "add-user";
    }
    @PostMapping("/delete")
    public String editUser(@RequestParam("id") int id) {
        System.out.println("delete user");
        userService.delete(id);
        return "redirect:/users";
    }
}
