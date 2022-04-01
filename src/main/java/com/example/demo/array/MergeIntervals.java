package com.example.demo.array;

import java.util.*;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * https://leetcode-cn.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> inter = Arrays.asList(intervals);
        List<int[]> newInter = new ArrayList<>(inter);
        newInter.sort((o1, o2) -> o1[0] - o2[0]);

        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < newInter.size(); )
        {
            int t = newInter.get(i)[1];
            int j = i + 1;
            while(j < newInter.size() && newInter.get(j)[0] <= t)
            {
                t = Math.max(t, newInter.get(j)[1]);
                j++;
            }
            res.add(new int[]{newInter.get(i)[0], t});
            i = j;
        }

        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++)
        {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1,4},{4,5}};
//        int[][] intervals = {{1,4},{0,4}};
        int[][] intervals = {{1,4},{0,0}};
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        MergeIntervals m = new MergeIntervals();
        System.out.println(Arrays.toString(m.merge(intervals)));;
    }

}
