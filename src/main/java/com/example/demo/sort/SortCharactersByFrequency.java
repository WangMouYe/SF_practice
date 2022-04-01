package com.example.demo.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 示例 1:
 * 输入:
 * "tree"
 * 输出:
 * "eert"
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * 输入:
 * "cccaaa"
 * 输出:
 * "cccaaa"
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 * 输入:
 * "Aabb"
 * 输出:
 * "bbAa"
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {
    /**
     * 先使用「哈希表」对词频进行统计；
     * 遍历统计好词频的哈希表，将每个键值对以 {字符,词频} 的形式存储到「优先队列（堆）」中。并规定「优先队列（堆）」排序逻辑为：
     * 如果 词频 不同，则按照 词频 倒序；
     * 如果 词频 相同，则根据 字符字典序 升序（由于本题采用 Special Judge 机制，这个排序策略随意调整也可以。
     * 但通常为了确保排序逻辑满足「全序关系」，这个地方可以写正写反，但理论上不能不写，否则不能确保每次排序结果相同）；
     * 从「优先队列（堆）」依次弹出，构造答案。
     */
    class Node {
        char c;
        int v;
        Node(char _c, int _v) {
            c = _c; v = _v;
        }
    }
    public String frequencySort(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Node> q = new PriorityQueue<>((a, b)->{
            if (b.v != a.v) return b.v - a.v;
            return a.c - b.c;
        });
        for (char c : map.keySet()) {
            q.add(new Node(c, map.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int k = poll.v;
            while (k-- > 0) sb.append(poll.c);
        }
        return sb.toString();
    }


    /**
     * 基本思路不变，将上述过程所用到的数据结构使用数组替代。
     * 具体的，利用 ASCII 字符集共 128128 位，预先建立一个大小为 128128 的数组，利用「桶排序」的思路替代「哈希表」和「优先队列（堆）」的作用。
     */
    public String frequencySort3(String s) {
        int[][] cnts = new int[128][2];
        char[] cs = s.toCharArray();
        for (int i = 0; i < 128; i++) cnts[i][0] = i;
        for (char c : cs) cnts[c][1]++;
        Arrays.sort(cnts, (a, b)->{
            if (a[1] != b[1]) return b[1] - a[1];
            return a[0] - b[0];
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            char c = (char)cnts[i][0];
            int k = cnts[i][1];
            while (k-- > 0) sb.append(c);
        }
        return sb.toString();
    }
}
