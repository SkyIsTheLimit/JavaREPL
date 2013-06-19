package com.skyisthelimit.jrepl.compiler;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import com.skyisthelimit.jrepl.exceptions.CouldNotCreateCompilerException;

public class Compiler implements DiagnosticListener<JavaFileObject> {
	private List<String> compilerOptions;
	private List<JavaSourceCode> codeObjects;
	private JavaCompiler compiler;
	private StandardJavaFileManager fileManager;
	private MasterClass masterClass;

	public Compiler() throws CouldNotCreateCompilerException {
		initialize();
	}

	private void initialize() throws CouldNotCreateCompilerException {
		this.compiler = ToolProvider.getSystemJavaCompiler();
		if (this.compiler == null)
			throw new CouldNotCreateCompilerException();
		this.fileManager = compiler.getStandardFileManager(this,
				Locale.getDefault(), Charset.defaultCharset());

		this.compilerOptions = new ArrayList<String>();
		this.compilerOptions.add("-d");
		this.compilerOptions.add("jrepl-bin");
		this.codeObjects = new ArrayList<JavaSourceCode>();
		this.masterClass = new MasterClass();

		this.codeObjects.add(this.masterClass);
	}

	public void addCodeObject(JavaSourceCode code) {
		this.codeObjects.add(code);
	}

	public MasterClass getMasterClass() {
		this.masterClass = new MasterClass();
		return this.masterClass;
	}

	private CompilationTask createCompilationTask(
			Iterable<String> compilerOptions,
			Iterable<? extends JavaFileObject> codeObjects) {
		return this.compiler.getTask(null, this.fileManager, this,
				compilerOptions, null, codeObjects);
	}

	public boolean compile() {
		// Create a compilation task
		CompilationTask task = createCompilationTask(this.compilerOptions,
				this.codeObjects);

		// FOR (JAVASOURCECODE CODE : THIS.CODEOBJECTS)
		// SYSTEM.OUT.PRINTLN("COMPILING: \N" + CODE.GETCODE()
		// + "\N**********************************");

		// Call the task
		boolean status = task.call();

		return status;
	}

	@Override
	public void report(Diagnostic<? extends JavaFileObject> e) {
		System.err.println(e.toString());
		try {
			System.err.println(e.getSource().getCharContent(true));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}