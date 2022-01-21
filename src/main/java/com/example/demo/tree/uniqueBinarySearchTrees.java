package com.example.demo.tree;

/**
 * 96. 不同的二叉搜索树
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 *
 * 1.dp[i]表示由1到i的数组成的二叉搜索树有几种形态(也就是i个数组成的二叉搜索树有几种形态)
 * 2.dp[i]的形态可分为，以1为头、以2为头...以i为头这些情况。
 * 对于以j为头结点的这一种具体情况，j将数值分为小于j的1...j-1的j-1个数和大于j的j+1...i的i-j个数两部分，分别在j的左子树和右子树上。
 * 所以，dp[i] = dp[j-1] * dp[i-j]; 遍历j,所有情况相加
 * 3. 当没有结点时，是一种形态。所以，dp[0] = 1;
 *
 * 作者：wjy-16
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/bu-tong-de-er-cha-sou-suo-shu-by-wjy-16-4azw/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class uniqueBinarySearchTrees {
    public int numTrees(int n) {
        int []a = new int [n+1];
        a[0] = 1;
        for (int i=1;i<n+1;i++){
            for (int j=1;j<=i;j++){
                a[i] += a[j-1]*a[i-j];
            }
        }
        return a[n];
    }

    public static void main(String[] args) {
        uniqueBinarySearchTrees u = new uniqueBinarySearchTrees();
        System.out.println(u.numTrees(3));
    }

}
