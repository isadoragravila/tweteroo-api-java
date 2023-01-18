package com.tweteroo.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;

@RestController
@RequestMapping("/tweets")
public class TweetController {

  @PostMapping
  public void createTweet(@RequestBody TweetDTO req) {
    System.out.println(req);
  }

  @GetMapping
  public void listAll() {
    System.out.println("get all tweets");
  }

  @GetMapping("/USERNAME")
  public void listAllByUser() {
    System.out.println("get all tweets by user");
  }
}
