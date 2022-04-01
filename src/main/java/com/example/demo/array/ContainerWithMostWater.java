package com.example.demo.array;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = 0;
        int i = 0, j = height.length-1;
        while (i<j){
            int resSub = Math.min(height[i],height[j])*(j-i);
            if (resSub>res) res = resSub;

            if (height[i] < height[j]){
                i++;
            }else if (height[i] > height[j]){
                j--;
            }else {
                i++;
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1,1};
        ContainerWithMostWater w = new ContainerWithMostWater();
        System.out.println(w.maxArea(height));
    }


    /**
     * 暴力双循环
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int n = height.length;
        int res = 0;
        for (int i=0;i<n;i++){
            int start = height[i]; //18
            int resSub = 0;
            int resSon = 0;
            for (int j=i+1;j<n;j++){
                int weight = j-i;//1
                int hei = Math.min(start,height[j]);//17
                resSon = hei*weight;
                resSub = Math.max(resSon,resSub);
            }
            System.out.println(resSub);
            res = Math.max(resSub,res);
        }
        return res;
    }

}
