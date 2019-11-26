package com.restapi.subreddit.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.subreddit.models.SubReddit;
import com.restapi.subreddit.models.Wrapper;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class SubRedditService {

public void getSubReddit(SubReddit subReddit){
  ObjectMapper mapper = new ObjectMapper();
  try {
    URL url = new URL("https://www.reddit.com/r/news/.json?20");
    HttpURLConnection request = (HttpURLConnection) url.openConnection();
    request.setRequestMethod("GET");
    request.setRequestProperty("User-Agent",
            "Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
    System.out.println(request.getContentType());
    BufferedReader serverResponse = new BufferedReader(
            new InputStreamReader(request.getInputStream()));
    String json = serverResponse.readLine();

    ObjectMapper objectMapper = new ObjectMapper();


    JsonNode root =
            objectMapper.readTree(json).get("data").get("children");
    Wrapper[] myObject = mapper.treeToValue(root, Wrapper[].class);
    System.out.println(myObject.toString());


  } catch (IOException e) {
    e.printStackTrace();
  }
}
}
