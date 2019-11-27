package com.restapi.subreddit.errors;


import com.restapi.subreddit.errors.RedditNotFoundException;
import com.restapi.subreddit.models.ErrorModel;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ControllerAdvice
@RestController
public class SubRedditServiceErrorAdvice {
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler({RedditNotFoundException.class})
  public ResponseEntity<Object> handle(RedditNotFoundException e) {
    return error(HttpStatus.NOT_FOUND, e);
  }


  private ResponseEntity<Object> error(HttpStatus status, Exception e) {
    ErrorModel errorObject =
            new ErrorModel(status, e.getLocalizedMessage());
    return new ResponseEntity<Object>(
            errorObject, new HttpHeaders(), status);

  }


}