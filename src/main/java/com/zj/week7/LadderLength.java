package com.zj.week7;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 *
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 *
 *  
 * 示例 1：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 示例 2：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 *  
 *
 * 提示：
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LadderLength {

    /**
     * 使用双向BFS
     * 最差情况是要将wordList（W）全部遍历一遍，且需要把单词每一个字符（C）都遍历一次分别替换26个字母
     * 所以时间复杂度是 O（WC * 26） = O（WC） 空间复杂度也是 O（WC）
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet();
        for(String word : wordList) {
            wordSet.add(word);
        }
        if(!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet();
        Set<String> endSet = new HashSet();
        Set<String> visited = new HashSet();
        beginSet.add(beginWord);
        endSet.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);
        int result = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            result ++;
            if(endSet.size() < beginSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> next = new HashSet();
            for(String s : beginSet) {
                char[] arrays = s.toCharArray();
                for(int i = 0; i < arrays.length; i ++) {
                    char old = arrays[i];
                    for(char j = 'a'; j <= 'z'; j ++) {
                        if(j == old) {
                            continue;
                        }
                        arrays[i] = j;
                        String tem = new String(arrays);
                        if(endSet.contains(tem)) {
                            return result;
                        }
                        if(!visited.contains(tem) && wordSet.contains(tem)) {
                            next.add(tem);
                            visited.add(tem);
                        }
                    }
                    arrays[i] = old;
                }
            }
            beginSet = next;
        }
        return 0;
    }

}
