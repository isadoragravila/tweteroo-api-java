package com.tweteroo.api.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

  public List<Tweet> findAll() {
    //adicionar paginação
    return tweetRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
  }

  public List<Tweet> findByUsername(String username) {
    List<Tweet> tweetsByUser = tweetRepository.findByUsername(username);

    Collections.sort(tweetsByUser, (t1, t2) -> (int) (t2.getId() - t1.getId()));

    return tweetsByUser;
  }

  public Tweet save(TweetDTO tweet) {
    List<User> user = userRepository.findByUsername(tweet.username());

    if(user.isEmpty()) {
      return null; //retornar erro
    }

    return tweetRepository.save(new Tweet(tweet, user.get(0).getAvatar()));
  }
}
