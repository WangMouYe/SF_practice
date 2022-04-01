package com.example.demo.binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * 在比较时，字母是依序循环出现的。举个例子：
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * 示例 1：
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * 示例 2:
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 * 示例 3:
 * 输入: letters = ["c","f","j"], target = "d"
 * 输出: "f"
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 */
public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter>target)return letter;
        }
        return letters[0];
    }

    public static void main(String[] args) {
        char []letters = {'c','f','j'};
        FindSmallestLetterGreaterThanTarget f = new FindSmallestLetterGreaterThanTarget();
        System.out.println(f.nextGreatestLetter(letters,'a'));
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        int ll = letters.length;
        Set<Character> set = new HashSet<>();
        for (int i=0;i<ll;i++){
            set.add(letters[i]);
        }
        set.add(target);
        char [] letFa = new char[set.size()];
        int j = 0;
        for (Character c : set) {
            letFa[j] = c;
            j++;
        }
        Arrays.sort(letFa);
        for (int i=0;i<set.size();i++){
            if (target==letFa[i]) {
                if (i==set.size()-1)return letters[0];
                else return letFa[i+1];
            }
        }
        return letters[0];
    }
}
