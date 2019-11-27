package com.restapi.subreddit.controllers;

import com.restapi.subreddit.models.SubReddit;
import com.restapi.subreddit.models.Wrapper;
import com.restapi.subreddit.services.SubRedditServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SubRedditController {

  @Autowired
  private SubRedditServiceImpl subRedditServiceImpl;

  public SubRedditController() {
    subRedditServiceImpl = new SubRedditServiceImpl();
  }


  @GetMapping("/subreddit/{name}")
  public ResponseEntity<List<SubReddit>> getsubreddit(@PathVariable("name") String name) {
    List<SubReddit> obj = subRedditServiceImpl.getSubReddit(name);
    return new ResponseEntity<List<SubReddit>>(obj, HttpStatus.OK);
  }

}
