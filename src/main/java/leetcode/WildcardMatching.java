package leetcode;

/*
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples: isMatch("aa","a") → false isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false isMatch("aa", "*") → true isMatch("aa", "a*") →
 * true isMatch("ab", "?*") → true isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		int si = 0, pi = 0, match = 0, startpi = -1;
		while (si < s.length()) {
			// ? or matching, increase both pointer
			if (pi < p.length()
					&& (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi))) {
				si++;
				pi++;
			}
			// * found, only increase pattern pointer
			else if (pi < p.length() && p.charAt(pi) == '*') {
				startpi = pi;
				match = si;
				pi++;
			}
			// last pattern pointer was *, increase string pointer
			else if (startpi != -1) {
				pi = startpi + 1;
				match++;
				si = match;
			}
			// current pointer is not *, last pattern pointer war not *
			else
				return false;
		}
		while (pi < p.length() && p.charAt(pi) == '*')
			pi++;
		return pi == p.length();
	}

}

// 贪心扫描 知道string 和pattern都到尾部
// 用一个特殊index记录当前*的开始位置和一个counter记录其match的长度