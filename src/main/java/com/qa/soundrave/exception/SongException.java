package com.qa.soundrave.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason ="Song not found!")
public class SongException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3126862525531283443L;


}
