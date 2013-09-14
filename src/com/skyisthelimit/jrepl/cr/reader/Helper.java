package com.skyisthelimit.jrepl.cr.reader;

import com.skyisthelimit.jrepl.cr.utils.StringUtilities;

public final class Helper {
	static public CodeReader getReader(String sourceCode) {
		// Implicitly assumes it's a <code>StringReader</code> to be used.

		String packageName = StringUtilities
				.between(sourceCode, "package", ";");
		String clazzName = StringUtilities.between(sourceCode, "class",
				"extends", "implements", "{");
		String fullyQualifiedName = packageName
				+ (packageName.trim().length() == 0 ? "" : ".") + clazzName;
		String code = sourceCode;

		System.out.println("FULL: " + fullyQualifiedName);

		return new StringReader(fullyQualifiedName, code);
	}
}
