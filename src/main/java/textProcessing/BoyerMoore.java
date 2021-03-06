package textProcessing;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {

	public static int findBoyerMoore(char[ ] text, char[ ] pattern) {
		int n = text.length;
		int m = pattern.length;
		
		if (m == 0) return 0;
		
		Map<Character,Integer> last = new HashMap<>( ); // the 'last' map
		
		for (int i=0; i < n; i++){
			last.put(text[i], -1);
		}
		for (int k=0; k < m; k++){
			last.put(pattern[k], k);
		}
		// start with the end of the pattern aligned at index m-1 of the text
		int i = m-1; // an index into the text
		int k = m-1;
		
		while (i < n) {
			if (text[i] == pattern[k]){// a matching character
				if (k == 0) return i; // entire pattern has been found
				i--; // otherwise, examine previous
				k--; // characters of text/pattern
			}else
			{
				i+=m-Math.min(k,1+last.get(text[i]));
				k=m-1;
			}
		}
		return -1;
		
	}
	public static void main(String[] args) {
		String text = "abacaabaccabacabaabb";
		String pattern = "abacab";
		System.out.println("Pattern found at :: "+findBoyerMoore(text.toCharArray(), pattern.toCharArray()));

	}

}
