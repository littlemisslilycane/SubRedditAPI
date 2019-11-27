package com.restapi.subreddit.services;

import com.restapi.subreddit.models.SubReddit;
import java.util.List;

public interface SubRedditService {

  List<SubReddit> getSubReddit(String name);

}
