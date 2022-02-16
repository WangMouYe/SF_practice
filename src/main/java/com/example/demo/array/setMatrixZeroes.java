package com.example.demo.array;

import java.util.*;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class setMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        // 1.首先寻找为0的位置 用一个list包裹map map里面 key存j value存i 因为key不能重复
        List<Map<Integer,Integer>> list = new ArrayList<>();// k j v i
        int dadArr = matrix.length;
        for (int i=0;i<dadArr;i++){
            Map<Integer,Integer> map = new HashMap<>();
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]==0){
                    map.put(j,i);
                }
            }
            list.add(map);
        }
        // 2.遍历list map entry
        for (Map<Integer, Integer> map : list) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int j = entry.getKey();
                int i = entry.getValue();
                int subArr = matrix[i].length;
                for (int x=0;x<dadArr;x++){
                    if (x==i)continue;
                    matrix[x][j] = 0;
                }
                for (int y=0;y<subArr;y++){
                    matrix[i][y] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] [] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        //[[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]原
        //[[0,0,0,0],[0,0,0,4],[0,0,0,0],[0,0,0,3],[0,0,0,0]]期望
        //[[0,0,0,0],[0,0,0,4],[0,0,0,4],[0,0,0,3],[0,0,0,0]]目前
//        int [] [] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
//        int [] [] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3,},{0,0,1,1}};
        setMatrixZeroes s = new setMatrixZeroes();
        s.setZeroes(matrix);
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

    }

}
