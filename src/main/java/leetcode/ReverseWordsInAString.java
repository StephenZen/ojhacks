package leetcode;
/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the". 

*/

import java.util.Stack;

public class ReverseWordsInAString {
public String reverseWords(String s) {
        
        Stack<String> stack = new Stack<String>();
        String[] strings = s.split(" +");
        int length = strings.length;
        if(length<1) return "";
        
        for(int i=0; i<length; i++){
            stack.push(strings[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++){
            String temp = stack.pop();
            sb.append(temp + " ");
            
        }
        
        return sb.toString().trim();
    }
}

// 感觉用了高级方法, split然后push到栈 最后pop出来
// 不然就只能一个一个扫字符了 ,注意用了split加正则的方法
