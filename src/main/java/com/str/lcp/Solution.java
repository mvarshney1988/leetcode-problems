package com.str.lcp;

public class Solution {
    private static TrieNode root;
    static int index=0;
    public String longestCommonPrefix(String[] strs) {
        root = new TrieNode();
        buildTrie(strs);
        String pre="";
        TrieNode node = root;
        while(children(node)==1 && node.isLeaf == false){
            node = node.children[index];
            pre=pre+ (char) ('a'+index);
        }
        System.out.println(pre);
        return pre;
    }
    int children(TrieNode node){
        int count=0;
        for(int i=0;i<26;i++){
            if(node.children[i] != null){
                count++;
                index=i;
            }
        }
        return count;
    }

    void buildTrie(String[] strs){
        for(int i=0;i<strs.length;i++){
            insert(strs[i]);
        }
    }

    void insert(String s){
        TrieNode node=root;
        for(int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node =node.children[index];

        }
        node.isLeaf=true;
    }
}
 class TrieNode{
    boolean isLeaf=false;

    TrieNode[] children;
    TrieNode(){
        children  = new TrieNode[26];
        for(int i=0;i<26;i++){
            children[i] = null;
        }
    }

}