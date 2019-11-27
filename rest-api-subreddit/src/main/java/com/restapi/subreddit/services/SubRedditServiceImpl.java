package com.restapi.subreddit.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.subreddit.errors.RedditNotFoundException;
import com.restapi.subreddit.models.SubReddit;
import com.restapi.subreddit.util.HTTPFetcher;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SubRedditServiceImpl {

  public List<SubReddit> getSubReddit(String name) {
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
      List<SubReddit> myObject = new ArrayList<>();
      Iterator<JsonNode> iter=root.iterator();
      while(iter.hasNext()) {
        JsonNode currentPost = iter.next().get("data");
        myObject.add(mapper.treeToValue(currentPost,
                SubReddit.class));
      }
      return myObject;


    } catch (IOException e) {

    }
    return null;
  }
}
