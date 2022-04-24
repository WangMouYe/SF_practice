package com.example.demo.array;


import java.util.*;

/**
 * 599. 两个列表的最小索引总和
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 * 示例 1:
 * 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * 输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 */
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap<>();
        int l1 = list1.length;
        int l2 = list2.length;
        for (int i=0;i<l1;i++){
            map.put(list1[i],i);
        }
        List<String> reList = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i=0;i<l2;i++){
            if (map.containsKey(list2[i])){
                int j = map.get(list2[i]);
                if (i + j < min) {
                    reList.clear();
                    reList.add(list2[i]);
                    min = i + j;
                } else if (i + j == min) {
                    reList.add(list2[i]);
                }
            }
        }

        return reList.toArray(new String[reList.size()]);

    }

    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists min = new MinimumIndexSumOfTwoLists();
        String[] list1= {"Shogun", "Tapioca Express", "Burger King", "KFC"}, list2 = {"KFC", "Shogun", "Burger King"};
        System.out.println(Arrays.toString(min.findRestaurant(list1,list2)));
    }


    public String[] findRestaurant2(String[] list1, String[] list2) {
        // 去重
        Map<String,Integer> disMap = new HashMap<>();
        // 比较
        Map<String,Integer> comMap = new HashMap<>();
        int l1 = list1.length;// 4 4 8
        int l2 = list2.length;
        for (int i=0;i<l1;i++){
            disMap.put(list1[i],1);
            comMap.put(list1[i],i);
        }
        for (int i=0;i<l2;i++){
            disMap.put(list2[i],disMap.getOrDefault(list2[i],0)+1);
            comMap.put(list2[i],comMap.getOrDefault(list2[i],0)+i);
        }

        Iterator<Map.Entry<String, Integer>> disIterator = disMap.entrySet().iterator();
        while (disIterator.hasNext()){
            Map.Entry<String, Integer> entry = disIterator.next();
            if (entry.getValue()==1) disIterator.remove();
        }

        // 通过两次循环 将两个数组中的元素导入map中
        // 现在map中包含了 餐厅名，索引和
        int min = Integer.MAX_VALUE;
        Iterator<Map.Entry<String, Integer>> it = comMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, Integer> next = it.next();
            if (disMap.containsKey(next.getKey())){
                min = Math.min(next.getValue(),min);
            }else {
                it.remove();
            }
        }
        // 找到min之后 再次遍历 找到相同大小的 之后放入String[]
        List<String> reList = new ArrayList<>();
        for (String s : comMap.keySet()) {
            if (comMap.get(s)==min){
                reList.add(s);
            }
        }

        return reList.toArray(new String[reList.size()]);
    }

}
