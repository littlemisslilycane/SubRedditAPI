package com.restapi.subreddit.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.subreddit.models.SubReddit;
import com.restapi.subreddit.util.HTTPFetcher;
import com.restapi.subreddit.util.Parser.JSONParseImpl;
import com.restapi.subreddit.util.Parser.JSONParser;
import com.restapi.subreddit.util.Parser.ParseSubRedditData;
import com.restapi.subreddit.util.Sort;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubRedditServiceImpl implements SubRedditService {
  public static ObjectMapper mapper;

  public SubRedditServiceImpl() {
    mapper = new ObjectMapper();
  }

  @Override
  public List<SubReddit> getSubReddit(String name) {
    HTTPFetcher fetcher = new HTTPFetcher(getUrlForSubReddit(name));
    List<SubReddit> subRedditData = getParsedData(fetcher);
    return subRedditData;
  }

  @Override
  public List<SubReddit> sort(String name, Sort type) {
    HTTPFetcher fetcher = new HTTPFetcher("https://www.reddit" +
            ".com/r/" + name + "/" + type + "/.json");
    List<SubReddit> subRedditData = getParsedData(fetcher);
    return subRedditData;
  }

  private List<SubReddit> getParsedData(HTTPFetcher fetcher) {
    String response = fetcher.getResponse();
    JSONParser strategy = new ParseSubRedditData();
    JSONParseImpl parser = new JSONParseImpl(response, strategy);
    List<SubReddit> subRedditData = new ArrayList<>();
    subRedditData = (List<SubReddit>) parser.Parse();
    return subRedditData;
  }

  private String getUrlForSubReddit(String name) {
    String baseUrl = "https://www.reddit.com/r/";
    String format = "json";
    return baseUrl + name + "/." + format;
  }
}
