package string;
//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
//
// 注意:
//假设字符串的长度不会超过 1010。
//
// 示例 1:
//
//
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
//
// Related Topics 哈希表

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class T409_LongestPalindrome {

    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0)return 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for(char ch : charArray){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }
        int result = 1;
        boolean ji = false;
        for( Character ch : map.keySet()){
            Integer count = map.get(ch);
            if(count % 2 == 0){
                result += count;
            }else{
                ji = true;
                if(count > 2){
                    result += count - 1;
                }
            }
        }
        return ji ? result + 1 : result;
    }

    public int longestPalindrome2(String s) {
        int[] charNum = new int[52];
        for(char ch : s.toCharArray()){
            charNum[ch - 'A']++;
        }
        int res = 0;
        for(int v : charNum){
            res += v - (v & 1);
        }
        return res < s.length() ? res + 1 : res;
    }

    public int longestPalindrome3(String s){
        Map<Integer, Integer> map = s.chars().boxed()
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));
        int res = map.values().stream().mapToInt(v -> v - (v & 1)).sum();
        return res < s.length() ? res + 1 : res;
    }

}
