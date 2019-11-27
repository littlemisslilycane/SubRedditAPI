package com.restapi.subreddit.services;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.subreddit.errors.RedditNotFoundException;
import com.restapi.subreddit.models.SubReddit;
import com.restapi.subreddit.util.HTTPFetcher;
import com.restapi.subreddit.util.Parser.JSONParseImpl;
import com.restapi.subreddit.util.Parser.JSONParser;
import com.restapi.subreddit.util.Parser.ParseSubRedditData;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class SubRedditServiceImpl implements SubRedditService {

  @Override
  public List<SubReddit> getSubReddit(String name) {
    ObjectMapper mapper = new ObjectMapper();
    HTTPFetcher fetcher = new HTTPFetcher("https://www.reddit.com/r/" + name + "/" +
            ".json?limit=10");
    String response = fetcher.getResponse();
    JSONParser strategy = new ParseSubRedditData();
    JSONParseImpl parser = new JSONParseImpl(response, strategy);
    List<SubReddit> subRedditData = new ArrayList<>();
    subRedditData = (List<SubReddit>) parser.Parse();
    return subRedditData;
  }
}
