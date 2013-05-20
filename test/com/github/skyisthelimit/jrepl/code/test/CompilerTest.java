package com.github.skyisthelimit.jrepl.code.test;

import org.junit.Test;

import com.github.skyisthelimit.jrepl.api.code.IAccessible;
import com.github.skyisthelimit.jrepl.code.Block;
import com.github.skyisthelimit.jrepl.code.Class;
import com.github.skyisthelimit.jrepl.code.Method;
import com.github.skyisthelimit.jrepl.code.Statement;
import com.github.skyisthelimit.jrepl.code.compile.Compiler;

public class CompilerTest {

	@Test
	public void test() {
		Statement statement = new Statement("int i = 0");
		Statement retStatement = new Statement("return new Integer(2)");

		System.out.println("STATEMENT: " + statement.toString());

		Block block = new Block();
		block.addCodeElement(statement);
		block.addCodeElement(retStatement);

		System.out.println("BLOCK: " + block.toString());

		Method method = new Method(IAccessible.PUBLIC, Integer.class,
				"sayHello");
		method.addCodeElement(block);

		System.out.println("METHOD: " + method.toString());

		Class clazz = new Class("", IAccessible.DEFAULT, "Message");
		clazz.addCodeElement(method);

		System.out.println("CLASS: " + clazz.toString());

		Compiler compiler = Compiler.getCompiler();

		compiler.compile(clazz);

		System.out.println("DONE");

	}
}
