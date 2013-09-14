package com.skyisthelimit.jrepl.cr.clazz;

import com.skyisthelimit.jrepl.cr.compiler.Compiler;
import com.skyisthelimit.jrepl.cr.reader.CodeReader;
import com.skyisthelimit.jrepl.cr.reader.Helper;

/**
 * 
 * @author Sandeep Prasad
 * 
 */
public class ExecutableClass extends JavaClass implements Compilable,
		Executable {
	// static private int M = 0x00;

	private boolean isCompiled;
	private boolean isExecuted;

	public ExecutableClass(CodeReader reader) {
		super(reader);

		isCompiled = false;
		isExecuted = false;
	}

	@Override
	public void compile() {
		this.isCompiled = true;
	}

	@Override
	public void execute() {
		this.isExecuted = true;
	}

	public boolean isCompiled() {
		return this.isCompiled;
	}

	public boolean isExecuted() {
		return this.isExecuted;
	}

	@Override
	public String getExecutableContents() {
		return this.getCode();
	}

	/**
	 * The public interface to the JavaREPL API will be similar to this.
	 * 
	 * @param compiler
	 *            The Java compiler to use.
	 * @param statement
	 *            The statement to execute.
	 * @return Returns an executable object. This executable object should
	 *         ideally be able to be passed to an executor like the
	 *         <code>Interpretter</code> etc.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * 
	 * @see Interpretter
	 */

	static public Executable wrap(Compiler compiler, String statement)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		CodeReader reader = Helper
				.getReader("package master; public class Master"
						+ " implements com.skyisthelimit.jrepl.cr.clazz.Executable"
						+ " { @Override"
						+ " public void execute() { "
						+ statement
						+ " } @Override"
						+ " public String getExecutableContents() { return \"\"; } }");

		System.out.println("Compilation: "
				+ compiler.compile(new ExecutableClass(reader)));

		// M++;

		return (Executable) ClassLoader.getSystemClassLoader()
				.loadClass("master.Master").newInstance();
	}
}