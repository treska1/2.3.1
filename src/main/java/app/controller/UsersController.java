package app.controller;


import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUser(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "allusers";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("user-delete/{id}")
    public String removeUser(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/";
    }


    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user",userService.getUserById(id));
        return "user-update";
    }

    @PostMapping("/user-update")
    public String userUpdate(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";

    }

}
