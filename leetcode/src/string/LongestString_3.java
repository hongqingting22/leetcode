package string;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LongestString_3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                Integer rep = map.get(c);
                start = Math.max(rep, start);
            }
            len = Math.max(len, end - start + 1);
            map.put(c, end + 1);
        }
        return len;

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>() {{
//            add(1);
//            add(3);
//            add(5);
        }};

        List<Integer> list2 = new ArrayList<Integer>() {
            {
                add(1);
//                add(2);
//                add(3);
            }
        };

        list.clear();
        list.addAll(list1);
        System.out.println("去重复交集前1：" + list1);
        System.out.println("去重复交集前2：" + list2);
        boolean b = list.retainAll(list2);
        System.out.println("list1与list2的交集是：" +b+ list);

    }
}
