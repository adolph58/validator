package com.example.validator.controller;

import com.example.validator.domain.User;
import com.example.validator.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Arte
 * @create 2020/6/18.
 */
@RestController
public class UserController {

    @GetMapping("/getUser")
    public Result<User> getUser(@RequestBody @Valid User user) {
        return Result.success(user);
    }
}
