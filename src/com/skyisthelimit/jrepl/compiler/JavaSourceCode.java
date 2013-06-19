package com.skyisthelimit.jrepl.compiler;

import java.io.IOException;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

public class JavaSourceCode extends SimpleJavaFileObject {
	protected String fullyQualifiedName;
	protected String code;
	private CodeReader reader;

	protected JavaSourceCode(URI uri, Kind kind) {
		super(uri, kind);
	}

	public JavaSourceCode(CodeReader reader) {
		super(URI.create(reader.getProtocol() + ":///"
				+ reader.getFullyQualifiedName().replaceAll("\\.", "/")
				+ Kind.SOURCE.extension), Kind.SOURCE);
		this.reader = reader;
		this.fullyQualifiedName = this.reader.getFullyQualifiedName();
		this.code = this.reader.getCode();
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors)
			throws IOException {
		return this.code;
	}

	public String getFullyQualifiedName() {
		return this.fullyQualifiedName;
	}

	public String getCode() {
		return this.code;
	}
}
