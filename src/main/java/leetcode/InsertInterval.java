package leetcode;

/*
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

 Example 2:
 Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

 This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
 */
import java.util.ArrayList;
import java.util.List;

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

// 有个boolean flag来追踪 new interval是佛加过
