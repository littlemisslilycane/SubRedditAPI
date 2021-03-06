package com.restapi.subreddit.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HTTPFetcher {
  private URL url;

  public HTTPFetcher(String url) {
    try {
      this.url = new URL(url);
    } catch (MalformedURLException ex) {

    }
  }

  public String getResponse() {
    String response = "";

    try {
      HttpURLConnection request = (HttpURLConnection) this.url.openConnection();
      request.setRequestMethod("GET");
      request.setRequestProperty("User-Agent",
              "Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");

      BufferedReader serverResponse = new BufferedReader(
              new InputStreamReader(request.getInputStream()));
      response = serverResponse.readLine();

    } catch (IOException ex) {

    }
    return response;
  }
}
