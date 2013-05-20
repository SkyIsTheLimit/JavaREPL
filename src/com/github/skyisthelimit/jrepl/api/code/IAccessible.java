package com.github.skyisthelimit.jrepl.api.code;

public interface IAccessible {
	public static final String PUBLIC = "public";
	public static final String PROTECTED = "protected";
	public static final String PRIVATE = "private";
	public static final String DEFAULT = "";

	String getAccessSpecifier();
}
