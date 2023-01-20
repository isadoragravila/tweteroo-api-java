package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.services.UserService;

@RestController
@RequestMapping("/sign-up")
public class AuthController {

  @Autowired
  private UserService service;
  
  @PostMapping
  public void signUp(@RequestBody UserDTO req) {
    service.save(req);
  }
}
