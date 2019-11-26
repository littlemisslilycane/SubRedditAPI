package com.restapi.subreddit.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("data")
public class SubReddit {

  private String id;
  private String subreddit;
  private String title;
  private String text;
  private int upvotes;
  private int downvotes;


  @JsonProperty("subreddit_id")
  public void setID(String id) {
    this.id = id;
  }

  @JsonProperty("subreddit_id")
  public String getID() {
    return this.id;
  }


  @JsonProperty("subreddit")
  public void setSubreddit_name(String name) {
    this.subreddit = name;
  }

  @JsonProperty("subreddit")
  public String getSubreddit_name() {
    return this.subreddit;
  }


  @JsonProperty("title")
  public void setTitle(String title) {
    this.title = title;
  }

  @JsonProperty("title")
  public String getTitle() {
    return this.title;
  }


  @JsonProperty("selftext")
  public void setText(String text) {
    this.text = text;
  }

  @JsonProperty("selftext")
  public String getText() {
    return this.text;
  }


  @JsonProperty("ups")
  public void setUps(int ups) {
    this.upvotes = ups;
  }

  @JsonProperty("ups")
  public int getUps() {
    return this.upvotes;
  }


  @JsonProperty("downs")
  public void setDowns(int downs) {
    this.downvotes = downs;
  }

  @JsonProperty("downs")
  public int getDowns() {
    return this.downvotes;
  }










}

