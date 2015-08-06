package strings;

public class KMP {
	private char[] pattern;
	private int[] lpsArray;

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
				lpsArray[i++] = ++len;
			} else {
				if (len != 0) {
					len = lpsArray[len - 1];
				} else {
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
