package com.restapi.subreddit.util.Parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.subreddit.errors.RedditNotFoundException;
import com.restapi.subreddit.models.SubReddit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParseSubRedditData implements JSONParser {

  private ObjectMapper objectMapper;

  public ParseSubRedditData() {
    objectMapper = new ObjectMapper();
  }

  @Override
  public Object Parse(String jsonData) {

    List<SubReddit> parsedData = new ArrayList<>();
    try {
      JsonNode root =
              objectMapper.readTree(jsonData).get("data").get("children");

      if (root.size() == 0) {
        throw new RedditNotFoundException("The entered sub-reddit is " +
                "invalid/does not exist");
      }

      Iterator<JsonNode> iter = root.iterator();
      while (iter.hasNext()) {
        JsonNode currentPost = iter.next().get("data");
        parsedData.add(objectMapper.treeToValue(currentPost,
                SubReddit.class));
      }
    } catch (IOException ex) {
      throw new RuntimeException("Parsing Error. Invalid data");
    }


    return parsedData;

  }
}
