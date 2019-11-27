package com.restapi.subreddit.services;

import com.restapi.subreddit.models.SubReddit;
import com.restapi.subreddit.util.Sort;

import java.util.List;

/**
 * This interface represents all the operations done on sub-reddits in the
 * given scope.
 */
public interface SubRedditService {

  List<SubReddit> getSubReddit(String name);

  List<SubReddit> sort(String name, Sort type);


}
