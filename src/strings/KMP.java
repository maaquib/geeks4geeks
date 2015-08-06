package strings;

public class KMP {
	private char[] pattern;

	/*
	 * longest suffix which is also a prefix of a sequence
	 */
	private int[] lpsArray;

	/*
	 * Constructor takes the pattern and pre-computes the lps array
	 */
	public KMP(String pattern) {
		this.pattern = pattern.toCharArray();
		lpsArray = new int[pattern.length()];
		computeLpsArray();
	}

	public void printLpsArray() {
		StringBuilder sb = new StringBuilder();
		sb.append("LPS Array : [");
		for (int i = 0; i < lpsArray.length; i++) {
			sb.append(lpsArray[i] + ",");
		}
		sb.deleteCharAt(sb.length() - 1).append("]");
		System.out.println(sb.toString());
	}

	private void computeLpsArray() {
		lpsArray[0] = 0;
		int i = 1, len = 0;
		while (i < pattern.length) {
			if (pattern[i] == pattern[len]) {
				/*
				 * If match then move both i and len, add len value to lpsArray
				 */
				lpsArray[i++] = ++len;
			} else {
				if (len != 0) {
					/*
					 * start checking for next character at lps of previous
					 */
					len = lpsArray[len - 1];
				} else {
					/*
					 * if len is at the beginning no lps found
					 */
					lpsArray[i++] = 0;
				}
			}
		}
	}

	public void matchPattern(String text) {
		char[] textToMatch = text.toCharArray();
		int i = 0, j = 0;
		while (i < textToMatch.length) {
			if (pattern[j] == textToMatch[i]) {
				i++;
				j++;
			}
			if (j == pattern.length) {
				System.out.println("Pattern Found at " + (i - j));
				/*
				 * set j as below to match overlapping patterns as well
				 */
				j = lpsArray[j - 1];
			} else if (i < textToMatch.length && pattern[j] != textToMatch[i]) {
				if (j != 0) {
					j = lpsArray[j - 1];
				} else {
					i++;
				}
			}
		}
	}
}
