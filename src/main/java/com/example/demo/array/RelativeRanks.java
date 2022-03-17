package com.example.demo.array;

import com.sun.java.swing.plaf.windows.WindowsTreeUI;

import java.util.*;

/**
 * 506. 相对名次
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 * 示例 1：
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 * 示例 2：
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 * https://leetcode-cn.com/problems/relative-ranks/
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) { // [10,3,8,9,4]
        int l = score.length;
        Map<Integer,Integer> scoreMap = new HashMap<>(l);
        for (int i=0;i<l;i++) {
            scoreMap.put(score[i],i);
        }
        Arrays.sort(score); // 3,4,8,9,10
        String [] res = new String[l];
        for (int i=0;i<l;i++){
            int s = scoreMap.get(score[i]); // 原下标
            if (i==l-1){ // 1st
                res[s] = "Gold Medal";
            }else if (i==l-2){ //2nd
                res[s] = "Silver Medal";
            } else if (i==l-3){ //3rd
                res[s] = "Bronze Medal";
            }else {
                res[s] = l-i+"";
            }
        }
        return res;
    }


    /**
     * map+排序 混搭 笨重解法
     * @param score
     * @return
     */
    public String[] findRelativeRanks1(int[] score) {
        int l = score.length;
        String [] res = new String[l];
        if (l==2){
            if (score[0]>score[1]){
                res[0] = "Gold Medal";
                res[1] = "Silver Medal";
            }else {
                res[0] = "Silver Medal";
                res[1] = "Gold Medal";
            }
            return res;
        }else if (l==1){
            res[0] = "Gold Medal";
            return res;
        }
        Map<Integer,Integer> scoreMap = new HashMap<>(l);
        List<Integer> list = new ArrayList<>(l);
        for (int i=0;i<l;i++) {
            scoreMap.put(score[i],i);
        }
        Arrays.sort(score);
        int first = score[l-1];
        int second = score[l-2];
        int third = score[l-3];
        for (int i=l-1;i>=0;i--) {
            list.add(score[i]);
        }

        for (Map.Entry<Integer, Integer> entry : scoreMap.entrySet()) {
            if (entry.getKey()==first){
                res[entry.getValue()] = "Gold Medal";
            }else if (entry.getKey()==second){
                res[entry.getValue()] = "Silver Medal";
            } else if (entry.getKey()==third){
                res[entry.getValue()] = "Bronze Medal";
            }else {
                res[entry.getValue()] = list.indexOf(entry.getKey())+1+"";
            }
        }
        return res;
    }



    public static void main(String[] args) {
        RelativeRanks r = new RelativeRanks();
//        int a []={10,3,8,9,4};
        int a []={1,2};
        System.out.println(Arrays.toString(r.findRelativeRanks(a)));
    }
}
