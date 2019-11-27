package com.restapi.subreddit.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This exception class handles cases when the given sub-reddit is not found or
 * in-valid.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RedditNotFoundException extends RuntimeException {
  public RedditNotFoundException(String message) {
    super(message);
  }
}