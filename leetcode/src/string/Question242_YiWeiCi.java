package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 使用字母表
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Question242_YiWeiCi {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];
        for(int i = 0;i<s.length();i++){
           arr[s.charAt(i) - 'a']++;
           arr[t.charAt(i) - 'a']--;
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i] != 0){
               return false;
            }
        }
        return true;

    }

    public boolean isAnagram2(String s,String t){
        if(s.length() != t.length())return false;
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            char c1 = t.charAt(i);
            Integer a = map.containsKey(c) ? map.get(c) : 0;
            Integer b = map.containsKey(c1) ? map.get(c1) : 0;
            map.put(c,a+1);
            map.put(c1,b-1);
        }
        for(Integer a : map.values()){
            if(a != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
