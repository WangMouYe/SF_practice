package com.example.demo.string;

/**
 * 243. 最短单词距离
 * 给定一个字符串数组 wordDict 和两个已经存在于该数组中的不同的字符串 word1 和 word2 。返回列表中这两个单词之间的最短距离。
 * 示例 1:
 * 输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * 输出: 3
 * 示例 2:
 * 输入: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * 输出: 1
 * https://leetcode-cn.com/problems/shortest-word-distance/
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int w1 = -1,w2 = -1;
        for (int i=0;i<wordsDict.length;i++){
            if (wordsDict[i].equalsIgnoreCase(word1))w1 = i;
            else if (wordsDict[i].equalsIgnoreCase(word2))w2 = i;
            if (w1!=-1 && w2!=-1){
                min = Math.min(Math.abs(w2-w1),min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        ShortestWordDistance s = new ShortestWordDistance();
        String [] wordsDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding", word2 = "practice";
        System.out.println(s.shortestDistance(wordsDict,word1,word2));
    }
}
