package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;

@Service
public class TweetService {
  
  @Autowired
  private TweetRepository tweetRepository;

  @Autowired
  private UserRepository userRepository;

  public Page<Tweet> findAll(Pageable page) {

    return tweetRepository.findAll(page);
  }

  public List<Tweet> findByUsername(String username) {
    return tweetRepository.findAllByUsernameOrderByIdDesc(username);
  }

  public Tweet save(TweetDTO tweet) {
    List<User> user = userRepository.findByUsername(tweet.username());

    if(user.isEmpty()) {
      return null;
    }

    return tweetRepository.save(new Tweet(tweet, user.get(0).getAvatar()));
  }
}
