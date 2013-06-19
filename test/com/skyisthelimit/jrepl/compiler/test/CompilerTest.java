package com.skyisthelimit.jrepl.compiler.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.junit.Assert;

import com.skyisthelimit.jrepl.compiler.Compiler;
import com.skyisthelimit.jrepl.interpretter.Interpretter;

public class CompilerTest {

	public static void main(String[] args) {
		new CompilerTest().test2();
	}

	public void test2() {
		try {
			Compiler compiler = new Compiler();

			BufferedReader x = new BufferedReader(new InputStreamReader(
					System.in));

			while (true) {
				try {
					System.out.print("jrepl> ");
					String input = x.readLine();
					// System.out.println("input = " + input);

					// compiler.getMasterClass().addGlobalCode("int i = 0;");
					// compiler.getMasterClass().addGlobalCode(
					// "System.out.println(\"The value of i = \" + i);");
					compiler.getMasterClass().addGlobalCode(input);

					if (compiler.compile())
						// Interpretter.invokeMethod("mytest.Test",
						// "testMessage");
						Interpretter.invokeMethod("master.Master", "main");

					System.out.println("MASTER FILE DELETED: "
							+ new File("jrepl-bin").delete());
				} catch (Exception exc) {
				}
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			Assert.fail(exc.getMessage());
		}
	}
}