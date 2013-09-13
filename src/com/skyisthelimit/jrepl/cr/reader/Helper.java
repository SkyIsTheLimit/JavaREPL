package com.skyisthelimit.jrepl.cr.reader;

public final class Helper {
	static public CodeReader getReader(String sourceCode) {
		// Implicitly assumes it's a <code>StringReader</code> to be used.

		String packageName = between(sourceCode, "package", ";");
		String clazzName = between(sourceCode, "class", "extends",
				"implements", "{");
		String fullyQualifiedName = packageName
				+ (packageName.trim().length() == 0 ? "" : ".") + clazzName;
		String code = sourceCode;

		System.out.println("FULL: " + fullyQualifiedName);

		return new StringReader(fullyQualifiedName, code);
	}

	static public String between(String text, String thiz, String that) {
		if (text.indexOf(thiz) == -1)
			return "";
		if (text.indexOf(that) == -1)
			return "";

		return text.substring(text.indexOf(thiz) + thiz.length(),
				text.indexOf(that)).trim();
	}

	static public String between(String text, String thiz, String... that) {
		int nearestIndex = 0;

		for (int i = 1; i < that.length; i++)
			if (text.indexOf(that[i]) != -1)
				if (text.indexOf(that[i]) < text.indexOf(that[nearestIndex])
						|| text.indexOf(that[nearestIndex]) == -1)
					nearestIndex = i;

		return between(text, thiz, that[nearestIndex]);
	}
}
