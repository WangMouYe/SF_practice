package com.example.demo.array;

/**
 * 566. 重塑矩阵
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * 示例 1：
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * 示例 2：
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 */
public class reshapeTheMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;

        if (r*c != n*m)return mat;
        int ans[][] = new int[r][c];
        int newRow = 0,newCol = 0;
        for (int row = 0; row < n; row++){
            for (int col = 0; col < m; col++){
                ans[newRow][newCol] = mat[row][col];
                if (newCol < c-1){
                    newCol++;
                }else {
                    newRow++;
                    newCol = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
