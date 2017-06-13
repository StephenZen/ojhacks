package leetcode;

/*
 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want. 
 */

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	List<String> ret = new ArrayList<String>();
	List<List<Character>> digitals = new ArrayList<List<Character>>();
	StringBuilder sb = new StringBuilder();

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0)
			return ret;
		makeDigitals();
		build(digits, 0);
		return ret;
	}

	// backtracking
	void build(String digits, int lvl) {
		if (lvl == digits.length()) {
			String s = sb.toString();
			ret.add(s);
			return;
		} else {
			char c = digits.charAt(lvl);
			int i = Integer.valueOf(c) - '0';
			if (i == 0 || (i <= 9 && i >= 2)) {
				List<Character> list = digitals.get(i);
				for (Character c1 : list) {
					sb.append(c1);
					build(digits, lvl + 1);
					sb.deleteCharAt(sb.length() - 1);
				}
			} else {
				return;
			}
		}
	}

	void makeDigitals() {
		List<Character> list0 = new ArrayList<Character>();
		list0.add(' ');
		digitals.add(0, list0);

		List<Character> list1 = new ArrayList<Character>();
		digitals.add(1, list1);

		List<Character> list2 = new ArrayList<Character>();
		list2.add('a');
		list2.add('b');
		list2.add('c');
		digitals.add(2, list2);

		List<Character> list3 = new ArrayList<Character>();
		list3.add('d');
		list3.add('e');
		list3.add('f');
		digitals.add(3, list3);

		List<Character> list4 = new ArrayList<Character>();
		list4.add('g');
		list4.add('h');
		list4.add('i');
		digitals.add(4, list4);

		List<Character> list5 = new ArrayList<Character>();
		list5.add('j');
		list5.add('k');
		list5.add('l');
		digitals.add(5, list5);

		List<Character> list6 = new ArrayList<Character>();
		list6.add('m');
		list6.add('n');
		list6.add('o');
		digitals.add(6, list6);

		List<Character> list7 = new ArrayList<Character>();
		list7.add('p');
		list7.add('q');
		list7.add('r');
		list7.add('s');
		digitals.add(7, list7);

		List<Character> list8 = new ArrayList<Character>();
		list8.add('t');
		list8.add('u');
		list8.add('v');
		digitals.add(8, list8);

		List<Character> list9 = new ArrayList<Character>();
		list9.add('w');
		list9.add('x');
		list9.add('y');
		list9.add('z');
		digitals.add(9, list9);
	}
}