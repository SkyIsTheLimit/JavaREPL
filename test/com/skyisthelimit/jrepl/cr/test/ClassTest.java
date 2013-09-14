package com.skyisthelimit.jrepl.cr.test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.skyisthelimit.jrepl.cr.clazz.JavaClass;
import com.skyisthelimit.jrepl.cr.compiler.Compiler;
import com.skyisthelimit.jrepl.cr.compiler.exception.CouldNotCreateCompilerException;
import com.skyisthelimit.jrepl.cr.reader.CodeReader;
import com.skyisthelimit.jrepl.cr.reader.Helper;

public class ClassTest {
	private JavaClass clazz;
	private Compiler compiler;

	@Before
	public void createClass() throws CouldNotCreateCompilerException {
		CodeReader reader = Helper
				.getReader("package jrepl; class JREPL { public void hello() { System.out.println(\"Hello World\"); } }");

		clazz = new JavaClass(reader) {
			@Override
			public void compile() {

			}
		};

		compiler = new Compiler();
	}

	@Test
	public void testCompilation() {
		Assert.assertTrue(compiler.compile(clazz));
	}

}
