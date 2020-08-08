package com.zsp1987.leetcode;
import java.util.ArrayList;
import java.util.List;

/*

Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null) return null;
        int len = nums.length;
        ArrayList<String> res = new ArrayList<String>();
        StringBuffer stringBuffer = new StringBuffer();
        if (len == 0) return res;
        int s = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                if (nums[i - 1] != s) {
                    stringBuffer.append(s);
                    stringBuffer.append("->");
                    stringBuffer.append(nums[i - 1]);

                } else {
                    stringBuffer.append(s);
                }
                s = nums[i];
                res.add(stringBuffer.toString());
                stringBuffer.setLength(0);
            }
        }
        if (nums[len - 1] != s) {
            stringBuffer.append(s);
            stringBuffer.append("->");
            stringBuffer.append(nums[len - 1]);

        } else {
            stringBuffer.append(s);
        }
        res.add(stringBuffer.toString());
        return res;
    }

}
