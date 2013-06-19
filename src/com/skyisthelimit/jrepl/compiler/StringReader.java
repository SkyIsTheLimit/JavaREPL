package com.skyisthelimit.jrepl.compiler;

/**
 * A simple <code>CodeReader</code> implementation.
 * 
 * @author Sandeep Prasad
 * @email sandeep3180@gmail.com
 * 
 */
public class StringReader implements CodeReader {
	private String fullyQualifiedName;
	private String code;

	public StringReader(String fullyQualifiedName, String code) {
		this.fullyQualifiedName = fullyQualifiedName;
		this.code = code;
	}

	@Override
	public String getFullyQualifiedName() {
		return this.fullyQualifiedName;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getProtocol() {
		return "string";
	}
}
