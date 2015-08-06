package strings;

public class RabinKarp {
	private static int RADIX = 256;

	public void matchPattern(String pattern, String text) {
		char[] pat = pattern.toCharArray();
		char[] txt = text.toCharArray();

		int hash = 1, patHash = 0, txtHash = 0;
		int prime = 101;

		/*
		 * Calculate h for removing leading element
		 */
		for (int i = 0; i < pat.length - 1; i++) {
			hash = (hash * RADIX) % prime;
		}

		/*
		 * calculate hash values for pattern and 1st window of text
		 */
		for (int i = 0; i < pat.length; i++) {
			patHash = (patHash * RADIX + pat[i]) % prime;
			txtHash = (txtHash * RADIX + txt[i]) % prime;
		}

		for (int i = 0; i <= txt.length - pat.length; i++) {
			if (patHash == txtHash) {
				int j;
				/*
				 * If hash values match check each character
				 */
				for (j = 0; j < pat.length; j++) {
					if (pat[j] != txt[i + j]) {
						break;
					}
				}
				if (j == pat.length) {
					System.out.println("Pattern Found at " + i);
				}
			}

			/*
			 * Hash value for next window by removing leading character and
			 * adding next character
			 */
			if (i < txt.length - pat.length) {
				txtHash = ((txtHash - txt[i] * hash) * RADIX + txt[pat.length + i]) % prime;
				if (txtHash < 0) {
					txtHash += prime;
				}
			}
		}
	}
}
