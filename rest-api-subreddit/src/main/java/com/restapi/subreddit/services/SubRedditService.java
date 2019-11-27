package com.restapi.subreddit.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.subreddit.errors.RedditNotFoundException;
import com.restapi.subreddit.models.Wrapper;
import com.restapi.subreddit.util.HTTPFetcher;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SubRedditService {

  public Wrapper getSubReddit(String name) {
    ObjectMapper mapper = new ObjectMapper();

    try {
      HTTPFetcher fetcher = new HTTPFetcher("https://www.reddit.com/r/" + name + "/" +
              ".json?limit=10");
      String response = fetcher.getResponse();
      ObjectMapper objectMapper = new ObjectMapper();


      JsonNode root =
              objectMapper.readTree(response).get("data").get("children");
      if (root.size() == 0) {
        throw new RedditNotFoundException("The entered sub-reddit" + name +
                " is not" +
                " found.");
      }
      Wrapper[] myObject = mapper.treeToValue(root, Wrapper[].class);
      return myObject[0];


    } catch (IOException e) {

    }
    return null;
  }
}
