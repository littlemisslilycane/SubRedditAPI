package com.restapi.subreddit.util.Parser;

public class JSONParseImpl {
  private String jsonData;
  private JSONParser parserStrategy ;

  public JSONParseImpl(String jsonData, JSONParser parserStrategy){
    this.jsonData = jsonData;
    this.parserStrategy = parserStrategy;
  }

  public Object Parse(){
    return  parserStrategy.Parse(this.jsonData);
  }
}
