package com.company;


import java.security.KeyStore;
import java.util.*;
import java.util.LinkedList;
import java.util.stream.Collectors.*;
import java.util.stream.*;

import static java.util.Map.Entry.*;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        BTree2 tree = new BTree2();
        tree.insert(10);
        tree.insert(1);
        tree.insert(45);
        tree.insert(44);
        tree.insert(21);
        tree.insert(75);
        tree.levelSearch();
    }

    static void permute(String s) {
        permute(s, 0, s.length() - 1);
    }
    static void permute(String str, int left, int right) {
        int N = str.length();
        int count = 0;
        for (int pos = 0; pos < N; pos++) {
            for (int c = pos; c < N; c++) {
                for (int i = c; i < N; i++) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    static void printFreqOrder(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            map.put(i, 1 + map.getOrDefault(i, 0));
        }
        Stream<Map.Entry<Integer, Integer>> sorted = map.entrySet().stream().sorted(comparingByValue());
        int[] result = sorted.mapToInt(x-> x.getKey()).toArray();
        System.out.println(Arrays.toString(result));
    }

    static void commonElems(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for(int i: arr1) {
            set.add(i);
        }
        for(int i: arr2) {
            if(set.contains(i)) {
                System.out.print(i + " ");
            }
        }
    }

    static void longestSubstrNoRepeat(String s) {
        int len = 0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        Set<Integer> repeat = new HashSet<>();
        for (int i = 1; i < s.length(); i++) {
            if(!set.add(s.charAt(i))) {
                repeat.add(i);
            }
        }

        int last = 0;
        for(int i: repeat) {
            if(i >= s.length()-1)
                i = s.length()-1;
            System.out.print(s.substring(last, i));
            last = i+1;
        }
    }
}
