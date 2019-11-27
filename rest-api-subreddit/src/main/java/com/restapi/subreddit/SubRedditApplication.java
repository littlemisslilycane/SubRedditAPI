package com.restapi.subreddit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
/**
 * This application is a wrapper for the subreddit API call in reddit's API.
 * Given a subredditname it fetches all the necessary details about the
 * subreddit as a JSON.
 */
public class SubRedditApplication {

  public static void main(String[] args) {
   	SpringApplication.run(SubRedditApplication.class, args);

  }

}
