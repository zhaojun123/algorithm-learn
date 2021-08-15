package com.zj.week2;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *  
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GroupAnagrams {

    //可以通过先排序 再hash的方式解决
    //其中 排序的时间复杂度是 O(klogk),再加上外层的循环 总体时间复杂度是 O(knlogk)，其中k是strs中字符串最大长度
    //空间复杂度用到了O(nk)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        if(strs == null) {
            return result;
        }
        Map<String,List> map = new HashMap();
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList());
            if(list.isEmpty()){
                result.add(list);
                map.put(key, list);
            }
            list.add(str);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = new GroupAnagrams().groupAnagrams(strs);
        List<List<String>> answer = Arrays.asList(Arrays.asList("bat"),Arrays.asList("nat","tan"),Arrays.asList("ate","eat","tea"));
        assert sort(result).equals(sort(answer));
    }

    public static List<String> sort(List<List<String>> list) {
        List<String> result = new ArrayList<>();
        for(List<String> paramList : list){
            paramList.sort(null);
            StringBuilder s = new StringBuilder();
            for(String str : paramList) {
                s.append(str);
            }
            result.add(s.toString());
        }
        result.sort(null);
        return result;
    }

}
