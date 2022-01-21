package com.example.demo.array;

import java.util.ArrayList;
import java.util.List;

/**
 *118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class pascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        for (int i=0; i<numRows; i++){
            int l = i+1;
            List<Integer> sub = new ArrayList<>(l);
            if (i==0) sub.add(1);
            else {
                sub.add(0,1);
                // 第一个和最后一个都是1 当前a[i]== 上一代a[i]+a[i-1]
                List<Integer> bro = list.get(i - 1);
                for (int j=1; j<i; j++){
                    sub.add(j,bro.get(j)+bro.get(j-1));
                }
                sub.add(i,1);
            }
            list.add(sub);
        }
        return list;
    }


    public static void main(String[] args) {
        pascalsTriangle p = new pascalsTriangle();
        System.out.println(p.generate(5));


    }

}
