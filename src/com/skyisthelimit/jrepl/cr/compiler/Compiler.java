package com.skyisthelimit.jrepl.cr.compiler;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.skyisthelimit.jrepl.cr.clazz.JavaClass;
import com.skyisthelimit.jrepl.cr.compiler.exception.CouldNotCreateCompilerException;

/**
 * The compiler part. This class initializes with the new api java provides for
 * dynamic compilation.
 * 
 * @author Sandeep Prasad
 * 
 */
public class Compiler implements DiagnosticListener<JavaFileObject> {
	// The global compiler options...
	private List<String> compilerOptions;
	// The compiler...
	private JavaCompiler compiler;
	// File Manager
	private StandardJavaFileManager fileManager;

	/**
	 * Default constructor...
	 * 
	 * @throws CouldNotCreateCompilerException
	 *             This exception is thrown if running on a jre rather than a
	 *             jdk.
	 */
	public Compiler() throws CouldNotCreateCompilerException {
		initialize();
	}

	/**
	 * Initialize the compiler.
	 * 
	 * @throws CouldNotCreateCompilerException
	 *             This exception is thrown if running on a jre rather than a
	 *             jdk.
	 */
	private void initialize() throws CouldNotCreateCompilerException {
		this.compiler = ToolProvider.getSystemJavaCompiler();
		if (this.compiler == null)
			throw new CouldNotCreateCompilerException();

		this.compilerOptions = new ArrayList<String>();

		// [TODO] Adding default options for testing. Will be removed!
		this.compilerOptions.add("-d");
		this.compilerOptions.add("bin");

		this.fileManager = compiler.getStandardFileManager(this,
				Locale.getDefault(), Charset.defaultCharset());
	}

	/**
	 * Helper method to create a compilation task. This compilation task is then
	 * sent to the compiler.
	 * 
	 * @param compilerOptions
	 *            The compiler options.
	 * @param codeObjects
	 *            The java sources to be compiled in this task.
	 * @return The compilation task created.
	 */
	private CompilationTask createCompilationTask(
			Iterable<String> compilerOptions,
			Iterable<? extends JavaFileObject> codeObjects) {
		return this.compiler.getTask(null, this.fileManager, this,
				compilerOptions, null, codeObjects);
	}

	/**
	 * Compile a compilable object. Helper method for the public compile method.
	 * 
	 * @param clazz
	 *            The java class to compile.
	 * @return Returns true if compilation was successfull else false.
	 */
	public boolean compile(JavaClass clazz) {
		// Get the code and compile it. No need to worry about execution here.

		// Create the list of compilable objects.
		List<JavaClass> compilableObjects = new ArrayList<JavaClass>();

		// [TODO] Compile only the uncompiled ones.
		compilableObjects.add(clazz);

		// Create a compilation task
		CompilationTask task = createCompilationTask(this.compilerOptions,
				compilableObjects);

		// Call the task
		boolean status = task.call();

		// The callback on compilable being called so it can do any extra
		// processing it wants.
		clazz.compile();

		return status;
	}

	/**
	 * Callback for any compilation errors.
	 */
	@Override
	public void report(Diagnostic<? extends JavaFileObject> diagnostic) {
		// [TODO] Do something here. Probably log or create observer pattern
		// here.

		System.out.println(diagnostic);
	}
}
