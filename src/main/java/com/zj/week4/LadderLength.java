package com.zj.week4;

import java.util.*;

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

    //时间复杂度 O(26 * beginWord.length * wordList.size()) 也就是 O(mn) m为beginWord长度 n为wordList长度
    //空间复杂度用了 beginVisited、endVisited、beginQueue、endQueue、wordSet char[] array 总体来说是O(n) n为wordList长度 或者 beginWord长度
    //使用双向bfs 分别从beginWord和endWord开始查找
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //将wordList中的单词放入到set中 方便后续检索
        Set<String> wordSet = new HashSet(wordList);
        if(!wordList.contains(endWord)) {
            return 0;
        }
        //begin 和 end 转换过的序列
        Set<String> beginVisited = new HashSet();
        Set<String> endVisited = new HashSet();
        LinkedList<String> beginQueue = new LinkedList();
        LinkedList<String> endQueue = new LinkedList();
        beginQueue.add(beginWord);
        beginVisited.add(beginWord);
        endQueue.add(endWord);
        endVisited.add(endWord);
        int step = 1;
        while(!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            step++;
            LinkedList queue = beginQueue;
            Set<String> visited = beginVisited;
            Set<String> target = endVisited;
            if(endQueue.size() < beginQueue.size()) {
                queue = endQueue;
                visited = endVisited;
                target = beginVisited;
            }
            if(bfs(queue, visited, target, wordSet)){
                return step;
            }
        }
        return 0;
    }

    public boolean bfs(LinkedList<String> queue, Set<String> visited, Set<String> target, Set<String> wordSet) {
        int size = queue.size();
        for(int k = 0; k < size; k ++) {
            String word = queue.poll();
            //改变一个字母,然后检查是否达成目标
            char[] array = word.toCharArray();
            for(int i = 0; i < array.length; i ++) {
                char change = array[i];
                for(char c = 'a'; c <= 'z'; c ++) {
                    array[i] = c;
                    String tem = new String(array);
                    if(!wordSet.contains(tem) || visited.contains(tem)) {
                        continue;
                    }
                    //找到目标
                    if(target.contains(tem)) {
                        return true;
                    }
                    visited.add(tem);
                    queue.add(tem);
                }
                array[i] = change;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        assert 5 == new LadderLength().ladderLength("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
    }

}
