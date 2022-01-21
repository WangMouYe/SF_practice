package com.example.demo.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 *
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 *
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 *
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class pascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>(rowIndex+1);

        for (int i=0;i<rowIndex+1;i++){
            int l = i+1;
            List<Integer> sub = new ArrayList<>(l);
            if (i==0) sub.add(1);
            else {
                sub.add(0,1);
                List<Integer> bro = list.get(i - 1);
                for (int j=1;j<i;j++){
                    sub.add(j,bro.get(j)+bro.get(j-1));
                }
                sub.add(i,1);
            }
            list.add(sub);
        }
        return list.get(rowIndex);
    }

    public static void main(String[] args) {
        pascalsTriangleII p = new pascalsTriangleII();
        System.out.println(p.getRow(3).toString());
    }
}
