package com.skyisthelimit.jrepl.cr.clazz;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;

import javax.tools.SimpleJavaFileObject;

import com.skyisthelimit.jrepl.cr.reader.CodeReader;
import com.skyisthelimit.jrepl.cr.reader.Helper;

/**
 * 
 * This class represents a java class file. Simply pass in a
 * <code>CodeReader</code> and create a java class.
 * 
 * @author Sandeep Prasad
 * 
 */
abstract public class JavaClass extends SimpleJavaFileObject {
	protected String fullyQualifiedName;
	protected String compilableCode;
	private CodeReader reader;
	private URI uri;

	private JavaClass(URI uri, Kind kind) {
		super(uri, kind);

		this.uri = uri;
	}

	public URI uri() {
		return this.uri;
	}

	public static String replace(String what, String with, String in) {
		String newString = "";

		for (int i = 0; i < in.length();) {
			if (in.substring(i).startsWith(what)) {
				newString += with;
				i += what.length();
			} else {
				newString += in.charAt(i);
				i++;
			}
		}

		return newString;
	}

	@SuppressWarnings("deprecation")
	public JavaClass(CodeReader reader) {
		this(URI.create(URLEncoder.encode(reader.getProtocol() + ":///"
				+ replace(".", "/", reader.getFullyQualifiedName())
				+ Kind.SOURCE.extension)), Kind.SOURCE);

		this.reader = reader;
		this.fullyQualifiedName = this.reader.getFullyQualifiedName();
		this.compilableCode = this.reader.getCode();
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors)
			throws IOException {
		return this.compilableCode;
	}

	public String getQualifiedName() {
		return this.fullyQualifiedName;
	}

	public String getCompilableCode() {
		return this.compilableCode;
	}

	public String getClassName() {
		if (fullyQualifiedName.indexOf('.') == -1)
			return fullyQualifiedName;

		return Helper.between(
				fullyQualifiedName + "|",
				fullyQualifiedName.substring(0,
						fullyQualifiedName.lastIndexOf('.') + 1), "|");

	}

	public String getPackageName() {
		if (fullyQualifiedName.indexOf('.') == -1)
			return "";

		return fullyQualifiedName.substring(0,
				fullyQualifiedName.lastIndexOf('.'));
	}

	@Override
	public String toString() {
		return this.compilableCode;
	}
}
