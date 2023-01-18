package com.tweteroo.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;

@RestController
@RequestMapping("/sign-up")
public class AuthController {
  
  @PostMapping
  public void signUp(@RequestBody UserDTO req) {
    System.out.println(req);
  }
}
