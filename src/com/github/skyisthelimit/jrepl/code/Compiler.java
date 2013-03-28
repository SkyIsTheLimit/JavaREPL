package com.github.skyisthelimit.jrepl.code;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.github.skyisthelimit.jrepl.api.code.ICompilable;
import com.github.skyisthelimit.jrepl.api.code.compile.ICompilationResult;
import com.github.skyisthelimit.jrepl.api.code.compile.ICompiler;

public class Compiler implements ICompiler {
	private static Compiler compiler;

	private Compiler() {
	}

	public static Compiler getCompiler() {
		if (compiler == null)
			compiler = new Compiler();

		return compiler;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cannot clone the compiler!");
	}

	@Override
	public ICompilationResult compile(ICompilable compilable) {
		JavaSourceCode code = new JavaSourceCode(compilable.getQualifiedName(),
				compilable.getCompilableCode());

		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		StandardJavaFileManager fileManager = compiler.getStandardFileManager(
				null, Locale.getDefault(), null);

		ArrayList<JavaSourceCode> sourceCodeObjects = new ArrayList<>();
		sourceCodeObjects.add(code);

		ArrayList<String> compilationOptions = new ArrayList<>();
		compilationOptions.add("-d");
		compilationOptions.add("bin");

		DiagnosticCollector<? super JavaFileObject> diagnostics = new DiagnosticCollector<>();

		CompilationTask compilerTask = compiler.getTask(null, fileManager,
				diagnostics, compilationOptions, null, sourceCodeObjects);

		boolean status = compilerTask.call();

		if (!status) {
			for (Diagnostic<?> diagnostic : diagnostics.getDiagnostics()) {
				System.out.format("Error on line %d ln %s",
						diagnostic.getLineNumber(), diagnostic);
			}
		} else {
			System.out.println("");
		}

		try {
			fileManager.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String[] getOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	class JavaSourceCode extends SimpleJavaFileObject {
		private String sourceCode;

		protected JavaSourceCode(String name, String code) {
			super(URI.create("string:///" + name.replace("\\.", "/")
					+ Kind.SOURCE.extension), Kind.SOURCE);

			this.sourceCode = code;
		}

		@Override
		public CharSequence getCharContent(boolean ignoreEncodingErrors)
				throws IOException {
			return sourceCode;
		}

		public String getSourceCode() {
			return sourceCode;
		}

		public void setSourceCode(String sourceCode) {
			this.sourceCode = sourceCode;
		}

	}
}