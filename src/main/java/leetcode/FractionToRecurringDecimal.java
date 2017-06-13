package leetcode;

import java.util.HashMap;

/*
 Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 */

public class FractionToRecurringDecimal {
	
	public String fractionToDecimal(int numerator, int denominator) {

		if (numerator == 0)
			return "0";
		StringBuilder sb = new StringBuilder();
		String sign = new String();
		if (numerator < 0 ^ denominator < 0)	//不能同时小于零
			sign="-";

		long n = Math.abs((long)numerator);
		long d = Math.abs((long)denominator);
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		
		long r = n % d;
		if (r == 0) {
			sb.append(sign);
			sb.append(n / d);
			return sb.toString();
		} 

		while (r != 0) {
			if (map.containsKey(r)) {
				sb.insert(map.get(r), "(");
				sb.append(")");
				break;
			}
			map.put(r, map.size());
			r*=10;
			sb.append(r/d);
			r=r%d;
		}
		sb.insert(0, sign);
		sb.insert(0, n/d+".");
		return sb.toString();

	}

}

// 先判断符号, 然后添加余数, 将余数放入hashmap里直到发现重复, 
// 将第一次出现重复后加(, 和最后加)
// 最后在首加符号, 然后向首尾里添加被除的整数部分,