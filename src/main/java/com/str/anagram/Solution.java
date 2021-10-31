package com.str.anagram;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> anagrams = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return anagrams;
        }

        int[] parr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            parr[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            int[] sarr = new int[26];
            for (int j = 0; j < p.length(); j++) {
                sarr[s.charAt(i+j) - 'a']++;
            }
            if (isMatch(parr, sarr)) {
                anagrams.add(i);
            }
        }
        return anagrams;
    }

    public boolean isMatch(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}