package com.skyisthelimit.jrepl.cr.utils;

public class StringUtilities {
	static public String replace(String what, String with, String in) {
		String newString = "";

		for (int i = 0; i < in.length();) {
			if (in.substring(i).startsWith(what)) {
				newString += with;
				i += what.length();
			} else {
				newString += in.charAt(i);
				i++;
			}
		}

		return newString;
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
