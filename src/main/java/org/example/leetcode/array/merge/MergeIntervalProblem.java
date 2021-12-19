package org.example.leetcode.array.merge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

/**
 * NC37 合并区间
 * https://www.nowcoder.com/practice/69f4e5b7ad284a478777cb2a17fb5e6a?tpId=190&&tqId=35348&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class MergeIntervalProblem {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));

        ArrayList<Interval> ans = new ArrayList<>();
        int len = intervals.size();
        if (len == 0) {
            return ans;
        }
        for (int i = 1; i < len; i++) {
            if (intervals.get(i).start <= intervals.get(i - 1).end) {
                intervals.get(i).start = Math.min(intervals.get(i).start, intervals.get(i - 1).start);
                intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i - 1).end);
            } else {
                //将前一个已合并的区间加入结果集
                ans.add(intervals.get(i - 1));
            }
        }
        //将最后一个区间加入结果集
        ans.add(intervals.get(len - 1));
        return ans;
    }
}


//Definition for an interval.
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}
