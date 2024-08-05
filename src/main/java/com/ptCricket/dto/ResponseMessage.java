/**
 * 
 */
package com.ptCricket.dto;

/**
 * @author manijauhari
 *
 */
public class ResponseMessage {
	
	private String message;

	  public ResponseMessage(String message) {
	    this.message = message;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }

}
