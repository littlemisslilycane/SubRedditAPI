package com.restapi.subreddit.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.subreddit.models.SubReddit;
import com.restapi.subreddit.models.Wrapper;
import com.restapi.subreddit.util.HTTPFetcher;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.ws.http.HTTPBinding;

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
      Wrapper[] myObject = mapper.treeToValue(root, Wrapper[].class);
      return myObject[0];

    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
