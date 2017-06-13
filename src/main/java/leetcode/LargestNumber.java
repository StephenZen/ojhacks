package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {


	public String largestNumber(int[] num) {
	 
		 if(num == null) return new String();

		 List<Integer> list = new ArrayList<Integer>();
		 for(int i: num){
			 list.add(i);
		 }
		 
		 Collections.sort(list, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = "" + o1 + o2;
				String s2 = "" + o2 + o1;
				
				return s2.compareTo(s1);		// reverse the order
			}
		});
		 
		StringBuilder sb = new StringBuilder();
		for(int n: list){
			sb.append(n);
		}
		if(sb.charAt(0)=='0') return "0";
		else return sb.toString();
		 
	 }
}

// 构建comparator 比较两个数构成的integer哪个大 用反顺序排列成从大到小
// 将列表中的字符串构建成结果