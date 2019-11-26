package com.restapi.subreddit.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("data")
public class SubReddit {

  private String id;
  private String title;
  private String text;

  @JsonProperty("self_text")
  public void setText(String text){
    this.text = text;
  }

  @JsonProperty("name")
  public String getText(){
    return this.text;
  }

  @JsonProperty("title")
  public void setTitle(String title){
    this.title = title;
  }

  @JsonProperty("title")
  public String getTitle(){
    return this.title;
  }

  @JsonProperty("subreddit_id")
  public void setID(String id){
    this.id = id;
  }

  @JsonProperty("subreddit_id")
  public String getID(){
    return this.id;
  }


  public String toString(){
    return this.title;
  }




}

