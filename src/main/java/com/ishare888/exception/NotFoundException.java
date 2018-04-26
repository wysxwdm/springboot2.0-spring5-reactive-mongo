package com.ishare888.exception;

/**
 * Created by rajeevkumarsingh on 22/10/17.
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String tweetId) {
        super("Tweet not found with id " + tweetId);
    }
    
}
