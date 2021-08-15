package com.zj.week2;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *  
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsAnagram {

    //因为都是小写字母,所以创建一个26位的数组来存储 s 和 t 字符的数量,然后再进行比较
    //时间复杂度是 O(n) 空间复杂度是用的是26位的数组所以是 O(1)
    public boolean isAnagram(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0) {
            return false;
        }
        int[] letters = new int[26];
        for(char c : s.toCharArray()) {
            int index = c - 'a';
            ++ letters[index];
        }
        for(char c : t.toCharArray()) {
            int index = c - 'a';
            //这里直接在原数组上判断,如果字符数量小于等于0,说明肯定不符合
            if(letters[index] <= 0) {
                return false;
            }
            -- letters[index];
        }
        for(int count : letters) {
            if(count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        assert isAnagram.isAnagram("anagram", "nagaram");
        assert !isAnagram.isAnagram("rat", "car");
    }

}
