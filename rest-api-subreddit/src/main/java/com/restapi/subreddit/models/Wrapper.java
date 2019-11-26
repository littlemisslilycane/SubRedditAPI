package com.restapi.subreddit.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("children")
public class Wrapper {

  public SubReddit data;

  @JsonProperty("data")
  public void setData(SubReddit data) {
    this.data = data;
  }

}