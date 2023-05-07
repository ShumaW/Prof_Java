package com.telran.employeeweb.controller;

import com.telran.employeeweb.model.entity.Employee;
import com.telran.employeeweb.model.entity.User;
import com.telran.employeeweb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/users")
@SessionAttributes("editUser")
public class UserController {

    private final UserService userService;

    @Value("${userNotPresentMessage}")
    private String userNotPresentMessage;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping
    public String getUser(Model model) {
        List<User> users = userService.getUser();
        model.addAttribute("users", users);
        model.addAttribute("userToAdd", new User());
        return "users";
    }

    @GetMapping("/find_user")
    public String findUser(@RequestParam(required = false) String username,
                               @RequestParam(required = false) String email,
                               Model model) {
        List<User> list = userService.findByUsernameOrEmail(username, email);
        if (!list.isEmpty()) {
            model.addAttribute("foundUser", list);
        } else {
            model.addAttribute("notPresentMessage", userNotPresentMessage);
        }
        return "findUserPage";
    }

    @GetMapping("/findByRole")
    public String findByRole(@RequestParam String role,
                             @PageableDefault(size = 5)
                             @SortDefault.SortDefaults({@SortDefault(sort = "username", direction = Sort.Direction.ASC)})
                             Pageable pageable, Model model){
        Sort sort = pageable.getSort();
        Page<User> page = userService.findAllByRole(role, pageable);
        model.addAttribute("page", page);
        String sortBy = "";
        if (sort.stream().iterator().hasNext()) {
            Sort.Order sortOrder = sort.stream().iterator().next();
            String property = sortOrder.getProperty();
            String order = sortOrder.getDirection().name();
            sortBy = property + "," + order;
        }
        model.addAttribute("sortBy", sortBy);
        return "findUserByRolePage";
    }

    @PostMapping
    public String addUser(@Valid @ModelAttribute User userToAdd, RedirectAttributes attributes) {
        User added = userService.addOrUpdate(userToAdd);
        attributes.addFlashAttribute("added", added.getId());
        return "redirect:/users";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String processException(RedirectAttributes attributes) {
        attributes.addFlashAttribute("error", "Please check input data");
        return "redirect:/users";
    }

    @PostMapping(value = "/edit")
    public String editUser(@RequestParam String userId, RedirectAttributes attributes) {
        System.out.println("Editing " + userId);
        attributes.addFlashAttribute("editUserId", userId);
        return "redirect:/users/editUserPage";
    }

    @PostMapping(value = "/delete")
    public String deleteEmployee(@RequestParam String userId, RedirectAttributes attributes) {
        System.out.println("Delete " + userId);
        userService.deleteUser(userId);
        attributes.addFlashAttribute("deleted", userId);
        return "redirect:/users";
    }

    @GetMapping("/editUserPage")
    public String editUserPage(Model model, HttpServletRequest request){
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        if (flashMap != null) {
            String userId = (String) flashMap.get("editUserId");
            if (userId != null) {
                Optional<User> user = userService.findById(userId);
                user.ifPresent(value -> model.addAttribute("editUser", value));
            }
        }
        return "editUserPage";
    }


    @PostMapping("/editUserPage")
    public String sendEditedUser(@ModelAttribute User user, Model model){
        model.addAttribute("editUser", user);
        return "redirect:/users/editUserPage2";
    }

    @GetMapping("/editUserPage2")
    public String editUserPage2(){
        return "editUserPage2";
    }

    @PostMapping("/editUserPage2")
    public String sendEditedUser2(@ModelAttribute User user, Model model){
        model.addAttribute("editEmployee", user);
        return "redirect:/users/confirmUserPage";
    }

    @GetMapping("/confirmUserPage")
    public String confirmEmployeePage() {
        return "confirmUserEditPage";
    }

    @PostMapping("/confirmUserPage")
    public String updateUser(Model model, RedirectAttributes attributes) {
        User user = (User) model.getAttribute("editUser");
        User updated = userService.addOrUpdate(user);
        attributes.addFlashAttribute("updated", updated.getId());
        return "redirect:/users";
    }

    @ModelAttribute("editUser")
    public User getEditedUser(){
        System.out.println("new User to edit added in Model");
        return new User();
    }
}
