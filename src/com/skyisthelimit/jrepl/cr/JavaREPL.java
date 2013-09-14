package com.skyisthelimit.jrepl.cr;

import com.skyisthelimit.jrepl.cr.interpretter.Interpretter;
import com.skyisthelimit.jrepl.cr.reader.CodeReader;

public class JavaREPL {
	static public JavaREPL createREPL(CodeReader reader, Compiler compiler,
			Interpretter interpretter) {
		return new JavaREPL();
	}
}
