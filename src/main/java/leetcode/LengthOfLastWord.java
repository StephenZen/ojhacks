package leetcode;

/*
 Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5. 
 */

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {

		char[] chars = s.toCharArray();
		int count = 0;
		int pre = count;
		for (int i = 0; i < chars.length; i++) {
			if (Character.isWhitespace(chars[i])) {
				if (count > 0) {
					pre = count;
				}
				count = 0;
			} else
				count++;
		}
		if (count == 0) {
			return pre;
		} else
			return count;

	}
}