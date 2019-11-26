package com.restapi.subreddit.controllers;

import com.restapi.subreddit.models.SubReddit;
import com.restapi.subreddit.models.Wrapper;
import com.restapi.subreddit.services.SubRedditService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class SubRedditController {

  @Autowired
  private SubRedditService subRedditService;

  public SubRedditController() {
    subRedditService = new SubRedditService();
  }

  @GetMapping("/subreddit/{name}")
  public Wrapper getsubreddit(@PathVariable("name") String name) {
    Wrapper obj = subRedditService.getSubReddit(name);
    return obj;
  }

}
