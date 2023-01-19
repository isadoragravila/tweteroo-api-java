package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;

@RestController
@RequestMapping("/tweets")
public class TweetController {

  @Autowired
  private TweetRepository tweetRepository;

  @Autowired
  private UserRepository userRepository;

  @PostMapping
  public void createTweet(@RequestBody TweetDTO req) {
    String avatar = userRepository.findByUsername(req.username()).get(0).getAvatar();

    //se não existir usuário, dar erro
    
    tweetRepository.save(new Tweet(req, avatar));
  }

  @GetMapping
  public List<Tweet> listAll() {
    return tweetRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
  }

  @GetMapping("/{USERNAME}")
  public void listAllByUser(@PathVariable String USERNAME) {
    System.out.println(USERNAME);
  }
}
