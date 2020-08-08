package com.zsp1987.leetcode;

/*

 Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:

 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]

 Note: Each word is guaranteed not to exceed L in length. 

 */

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int L) {
        List<String> currList = new ArrayList<String>();
        List<String> ret = new ArrayList<String>();
        int counts = 0, len = 0;
        StringBuilder sb = new StringBuilder();

        while (counts < words.length) {
            // 1. put the first word into the line
            sb.setLength(0);
            sb.append(words[counts]);
            currList.clear();
            len = words[counts].length();
            counts++;

            // 2. Handle the rest of the words for each line
            while (counts < words.length && len + 1 + words[counts].length() <= L) {
                currList.add(" " + words[counts]);
                len += words[counts].length() + 1;
                counts++;
            }

            // 3. Calculate the number of spaces we need and insert into the curlist
            if (counts < words.length && currList.size() > 0) {
                int numSpaces = L - len;
                int avg = numSpaces / currList.size();
                int rem = numSpaces % currList.size();
                for (int i = 0; i < currList.size(); i++) {
                    appendSpace(sb, i < rem ? avg + 1 : avg);
                    sb.append(currList.get(i));
                }
            } else {
                // 4. Special case for the last line
                for (int j = 0; j < currList.size(); j++) {
                    sb.append(currList.get(j));
                }
                appendSpace(sb, L - len);
            }
            ret.add(sb.toString());
        }
        return ret;
    }

    private void appendSpace(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
    }

}

// �?行填字 空格个数通过除法算出�?�
