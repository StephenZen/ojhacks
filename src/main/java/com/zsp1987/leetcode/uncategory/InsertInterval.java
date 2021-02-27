package com.zsp1987.leetcode.uncategory;

import java.util.ArrayList;
import java.util.List;

import com.zsp1987.leetcode.datatype.Interval;

public class InsertInterval {
	List<Interval> result = new ArrayList<Interval>();

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals == null || newInterval == null)
			return intervals;
		boolean add = false;
		for (Interval itvl : intervals) {
			if (itvl.end < newInterval.start)
				result.add(itvl);
			else if (itvl.start <= newInterval.end
					&& itvl.end >= newInterval.start) {
				newInterval.start = itvl.start < newInterval.start ? itvl.start
						: newInterval.start;
				newInterval.end = itvl.end > newInterval.end ? itvl.end
						: newInterval.end;
				if (itvl.end >= newInterval.end) {
					result.add(newInterval);
					add = true;
				}
			} else if (itvl.start > newInterval.end) {
				if (add == false) {
					result.add(newInterval);
					add = true;
				}
				result.add(itvl);
			}

		}
		if (add == false) {
			result.add(newInterval);
		}

		return result;

	}
}

// 有个boolean flag�?�追踪 new interval是佛加过
