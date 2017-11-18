//package com.cat.zsy.mvc.controller;
//
//import com.cat.zsy.mvc.domain.User;
//import com.cat.zsy.mvc.service.UserService;
//import lombok.Setter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Collections;
//import java.util.List;
//
//@RestController
//@RequestMapping("users")
//public class UserController {
//
//    @Setter(onMethod = @__(@Autowired))
//    private UserService userService;
//
//    @GetMapping
//    public Page<User> list() {
//        return userService.findByNameContains("1", PageRequest.of(0, 10));
//    }
//
//    @GetMapping("/2")
//    public List<User> list2() {
//        User user = new User().setId(1L).setName("csl").setSex("man");
//        return Collections.singletonList(user);
//    }
//}
