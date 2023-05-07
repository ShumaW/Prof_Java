package com.telran.employeeweb.controller;

import com.telran.employeeweb.model.entity.Employee;
import com.telran.employeeweb.model.entity.User;
import com.telran.employeeweb.service.UserService;
import com.telran.employeeweb.validator.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/usersRest")
public class UserRestController {

    public UserService userService;

    private final UserValidator validator;

    @Autowired
    public UserRestController(UserService userService, UserValidator validator) {
        this.validator = validator;
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("/page")
    public Page<User> getUserPage(@PageableDefault(size = 5) Pageable pageable){
        return userService.getUser(pageable);
    }

    @GetMapping(value = "/find")
    public List<User> findUser(@RequestParam(required = false) String name,
                               @RequestParam(required = false) String email) {
        return userService.findByUsernameOrEmail(name, email);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addOrUpdate(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        Long userId = user.getId();
        User updatedUser = userService.addOrUpdate(user);
        boolean isUpdated = updatedUser.getId().equals(userId);
        return new ResponseEntity<>(updatedUser, isUpdated ? HttpStatus.OK : HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUserNameAndRole(@PathVariable String id,
                                                                @RequestParam String username,
                                                                @RequestParam String role){
        User user = userService.updateUserNameAndRole(id, username, role);
        return new ResponseEntity<>(user, user != null ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable String id) {
        System.out.println("Deleting:" + id);
        userService.deleteUser(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @InitBinder
    public void addBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }
}
