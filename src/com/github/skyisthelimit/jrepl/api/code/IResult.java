package com.github.skyisthelimit.jrepl.api.code;

/**
 * A generic Result type. This type is used for packaging a Compilation Result
 * or an Execution Result.
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 */
public interface IResult {
	String getMessage();

	Exception[] getExceptions();
}
