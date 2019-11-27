package com.restapi.subreddit.models;

import org.springframework.http.HttpStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class represents a response entity when an exception occurs in the
 * application.
 */
public class ErrorModel {

  private HttpStatus status;
  private String message;
  private String timestamp;
  private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM" +
          "/yyyy HH:mm:ss");

  public ErrorModel(HttpStatus status, String message) {
    super();
    this.status = status;
    this.message = message;
    this.timestamp = formatter.format(new Date());
  }


}