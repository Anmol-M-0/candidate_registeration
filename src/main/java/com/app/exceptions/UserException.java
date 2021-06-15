package com.app.exceptions;

@SuppressWarnings("serial")
public class UserException extends RuntimeException {
public UserException() {
	super("error in validating user");
}
public UserException(String msg) {
	super(msg);
}
}
