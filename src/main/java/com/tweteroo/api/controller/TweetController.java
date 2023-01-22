package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.services.TweetService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tweets")
public class TweetController {

  @Autowired
  private TweetService service;

  @GetMapping
  public Page<Tweet> listAll(
      @PageableDefault(page = 0, size = 5, sort = { "id" }, direction = Sort.Direction.DESC) Pageable page) {

    return service.findAll(page);
  }

  @GetMapping("/{username}")
  public ResponseEntity<List<Tweet>> listAllByUser(@PathVariable String username) {
    var tweetsByUser = service.findByUsername(username);
    if (tweetsByUser != null) {
      return ResponseEntity.ok().body(tweetsByUser);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public void createTweet(@RequestBody TweetDTO req) {
    service.save(req);
  }
}
