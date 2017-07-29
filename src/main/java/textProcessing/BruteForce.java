package textProcessing;

public class BruteForce {
	public static int findBrute(char[] text, char[] pattern) {
		int n = text.length;
		int m = pattern.length;
		for (int i = 0; i <= n - m; i++) { // try every starting index within
											// text
			int k = 0; // k is index into pattern
			while (k < m && text[i + k] == pattern[k])
				// kth character of pattern matches
				k++;
			if (k == m)
				return i;// substring text[i..i+m-1] is a match

		}
		return -1; // search failed
	}

	public static void main(String[] args) {
		String text = "abacaabaccabacabaabb";
		String pattern = "abacab";
		System.out.println("Pattern found at :: "+findBrute(text.toCharArray(), pattern.toCharArray()));
	}
}
