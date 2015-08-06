package strings;

public class SearchTest {

	public static void main(String[] args) {
		KMP kmp = new KMP("ABAB");
		kmp.printLpsArray();
		kmp.matchPattern("ABABDABACDABABCABAB");
	}
}
