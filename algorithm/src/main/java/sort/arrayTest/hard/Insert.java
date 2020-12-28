//package sort.arrayTest.hard;
//
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//
///**
// * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
// *
// * 在列表中插入一个新的区间，
// * 你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
// */
//public class Insert {
//
//    public int[][] insert(int[][] intervals, int[][] newInterval) {
//        // init data
//        int newStart = newInterval[0][0], newEnd = newInterval[0][1];
//        int idx = 0, n = intervals.length;
//        LinkedList<int[]> output = new LinkedList<int[]>();
//
//        // add all intervals starting before newInterval
//        while (idx < n && newStart > intervals[idx][0])
//            output.add(intervals[idx++]);
//
//        // add newInterval
//        int[] interval = new int[2];
//        // if there is no overlap, just add the interval
//        if (output.isEmpty() || output.getLast()[1] < newStart)
//            output.add(newInterval);
//            // if there is an overlap, merge with the last interval
//        else {
//            interval = output.removeLast();
//            interval[1] = Math.max(interval[1], newEnd);
//            output.add(interval);
//        }
//
//        // add next intervals, merge with newInterval if needed
//        while (idx < n) {
//            interval = intervals[idx++];
//            int start = interval[0], end = interval[1];
//            // if there is no overlap, just add an interval
//            if (output.getLast()[1] < start) output.add(interval);
//                // if there is an overlap, merge with the last interval
//            else {
//                interval = output.removeLast();
//                interval[1] = Math.max(interval[1], end);
//                output.add(interval);
//            }
//        }
//        return output.toArray(new int[output.size()][2]);
//    }
//
//    public int[][] insert1(int[][] intervals, int[][] newInterval) {
//        if (newInterval == null || intervals == null) {
//            return intervals;
//        }
//
//        List<int[]> results = new ArrayList<int[]>();
//        int insertPos = 0;//插入位置
//
//        for (int[] interval : intervals) {//遍历intervals
//            if (interval[1] < newInterval[0]) {//如果当前区间的end小于新区间的start，说明无重叠，直接添加
//                results.add(new int[]{interval[0], interval[1]});
//                insertPos++;//插入位置+1
//            } else if (interval[0] > newInterval[1]) {//如果当前区间的start小于新区间的end，说明无重叠，直接添加
//                results.add(new int[]{interval[0], interval[1]});
//            } else {//否则一定有重叠，取两个区间的最小start，和最大end, 作为新区间
//                newInterval[0] = Math.min(interval[0], newInterval[0]);
//                newInterval[1] = Math.max(interval[1], newInterval[1]);
//            }
//        }
//
//        results.add(insertPos, new int[]{newInterval[0], newInterval[1]});
//
//        return results.toArray(new int[results.size()][2]);
//    }
//}