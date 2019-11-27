package com.restapi.subreddit.controllers;

import com.restapi.subreddit.models.SubReddit;
import com.restapi.subreddit.services.SubRedditServiceImpl;
import com.restapi.subreddit.util.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
@EnableWebMvc
@RestController
@CrossOrigin("*")
public class SubRedditController {

  @Autowired
  private SubRedditServiceImpl subRedditServiceImpl;

  public SubRedditController() {
    subRedditServiceImpl = new SubRedditServiceImpl();
  }


  /**
   * Get the list of posts under a given subreddit.
   * @param name subreddit name
   * @return Sub reddit posts
   */
  @GetMapping("/subreddit/{name}")
  public ResponseEntity<List<SubReddit>> getSubreddit(@PathVariable("name") String name) {
    List<SubReddit> obj = subRedditServiceImpl.getSubReddit(name);
    return new ResponseEntity<List<SubReddit>>(obj, HttpStatus.OK);
  }

  /**
   * Given a sub reddit it sorts all the posts based on the categories Hot,
   * top, controversial, rising.
   * @param name subreddit name
   * @param type sort type belonging to the type Enum Sort
   * @return list of posts in a subreddit
   */
  @GetMapping("/subreddit/{name}/{sort}")
  public ResponseEntity<List<SubReddit>> sortSubReddit(@PathVariable("name") String name, @PathVariable("sort") Sort type) {
    List<SubReddit> obj = subRedditServiceImpl.sort(name, type);
    return new ResponseEntity<List<SubReddit>>(obj, HttpStatus.OK);
  }


}
