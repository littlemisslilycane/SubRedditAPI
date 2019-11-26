package com.restapi.subreddit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SubRedditApplication {

  public static void main(String[] args) {
   	SpringApplication.run(SubRedditApplication.class, args);

  }

}
