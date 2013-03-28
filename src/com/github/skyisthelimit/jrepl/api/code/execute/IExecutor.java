package com.github.skyisthelimit.jrepl.api.code.execute;


/**
 * Represents the run time.
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 */
public interface IExecutor {
	IExecutionResult execute(IExecutable executable);
}
