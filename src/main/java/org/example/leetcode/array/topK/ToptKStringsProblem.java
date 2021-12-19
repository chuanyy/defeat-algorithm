package org.example.leetcode.array.topK;

import java.util.*;

/**
 * NC97 字符串出现次数的TopK问题
 * https://www.nowcoder.com/practice/fd711bdfa0e840b381d7e1b82183b3ee?tpId=190&&tqId=36047&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class ToptKStringsProblem {
    /**
     * return topK string
     * @param strings string字符串一维数组 strings
     * @param k int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        if (null == strings || strings[0].length() == 0 || k <= 0) {
            return new String[][]{};
        }

        Map<String, Integer> tmap = new TreeMap<>();
        for (String s : strings) {
            tmap.put(s, tmap.getOrDefault(s, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(tmap.entrySet());
        // 先比较值是否相同，相同按键升序进行比较，不相同按值降序比较
        list.sort((o1, o2) -> o1.getValue().equals(o2.getValue()) ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue()));

        String[][] result = new String[k][2];
        for (int i = 0; i < k; i++) {
            result[i][0] = list.get(i).getKey();
            result[i][1] = list.get(i).getValue().toString();
        }

        return  result;
    }

    // 1.使用map存放字符串出现的次数
    // 2.使用优先级队列存放出现次数最多的k个字符串
    //   2.1 常规的就是小顶堆，队列头部是最小的 offer和poll都是顶部元素
    public String[][] topKstrings2 (String[] strings, int k) {
        // write code here
        HashMap<String,Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))){
                return o2.compareTo(o1);
            }else {
                return map.get(o1) - map.get(o2);
            }
        });


        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            //
            queue.offer(entry.getKey());

            if (queue.size() > k){
                queue.poll();
            }
        }
        String[][] res = new String[k][2];
        for (int i = 0; i < k; i++) {
            String cur = queue.poll();
            res[k-1-i] = new String[]{ cur,String.valueOf(map.get(cur)) } ;
        }
        return res;

    }
}
