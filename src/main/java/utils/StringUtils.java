package utils;

public class StringUtils {

	public static String spaces(int n) {
		return repeat2(' ', n);
	}

	public static String repeat2(char c, int n) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < n; j++)
			sb.append(c);
		return sb.toString();
	}

}
