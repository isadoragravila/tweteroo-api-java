package com.tweteroo.api.model;

import com.tweteroo.api.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tweets")
public class Tweet {

  public Tweet(TweetDTO data, String avatar) {
    this.username = data.username();
    this.tweet = data.tweet();
    this.avatar = avatar;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String avatar;

  @Column(nullable = false)
  private String tweet;
  
}
