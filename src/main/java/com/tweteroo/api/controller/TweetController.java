package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.services.TweetService;

@RestController
@CrossOrigin
@RequestMapping("/api/tweets")
public class TweetController {

  @Autowired
  private TweetService service;

  @GetMapping
  public List<Tweet> listAll() {
    return service.findAll();
  }

  @GetMapping("/{username}")
  public List<Tweet> listAllByUser(@PathVariable String username) {
    return service.findByUsername(username);
  }

  @PostMapping
  public void createTweet(@RequestBody TweetDTO req) {
    service.save(req);
  }
}
