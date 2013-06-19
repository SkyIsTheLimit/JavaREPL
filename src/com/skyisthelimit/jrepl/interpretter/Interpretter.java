package com.skyisthelimit.jrepl.interpretter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Interpretter {
	private static List<Method> scanMethodsWithName(Class<?> clazz,
			String methodName) {
		List<Method> methods = new ArrayList<Method>();

		for (Method method : clazz.getMethods()) {
			if (method.getName().equalsIgnoreCase(methodName))
				methods.add(method);
		}

		return methods;
	}

	public static Object invokeMethod(String qualifiedName,
			String voidMethodName) throws SecurityException,
			IllegalArgumentException, ClassNotFoundException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException {
		return invokeMethod(qualifiedName, voidMethodName, (Class<?>[]) null,
				new Object[] {});
	}

	public static Object invokeMethod(String qualifiedName, String methodName,
			Object... params) throws SecurityException,
			IllegalArgumentException, ClassNotFoundException,
			NoSuchMethodException, IllegalAccessException,
			InvocationTargetException, InstantiationException {
		return invokeMethod(qualifiedName, methodName, (Class<?>[]) null,
				params);
	}

	public static Object invokeMethod(String qualifiedClassName,
			String methodName, Class<?>[] paramTypes, Object... params)
			throws ClassNotFoundException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException {
		Class<?> c = Class.forName(qualifiedClassName);

		// Method m = c.getMethod(methodName, paramTypes);

		Method m = null;

		List<Method> methods = scanMethodsWithName(c, methodName);
		if (methods.size() == 0)
			throw new NoSuchMethodException();
		else if (methods.size() == 1)
			m = methods.get(0);
		else {
			// More than one method. Ask user.
			try {
				System.out.println("Here is a list of methods obtained: \n");
				for (int i = 0; i < methods.size(); i++)
					System.out.println(i + ". " + methods.get(i).toString());
				System.out.print("Enter your choice: ");
				BufferedReader x = new BufferedReader(new InputStreamReader(
						System.in));
				int answer = Integer.parseInt(x.readLine());

				m = methods.get(answer);
			} catch (Exception exc) {

			}
		}

		return m.invoke(c.newInstance(), params);
	}
}
