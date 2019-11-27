/*
package com.restapi.subreddit.controllers;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping({SubRedditErrorController.ERROR_PATH})
public class SubRedditErrorController extends AbstractErrorController {

  static final String ERROR_PATH = "/error";

  public SubRedditErrorController(final ErrorAttributes errorAttributes) {
    super((org.springframework.boot.web.servlet.error.ErrorAttributes) errorAttributes, Collections.emptyList());
  }

  @RequestMapping
  public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
    Map<String, Object> body = this.getErrorAttributes(request, false);
    HttpStatus status = this.getStatus(request);
    return new ResponseEntity<>(body, status);
  }

  @Override
  public String getErrorPath() {
    return ERROR_PATH;
  }
}*/
