package com.company;

import java.util.*;
import java.util.LinkedList;
import java.util.stream.Stream;

public class InterviewPrep {

    static void sortArrayByFrequency(Integer[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Integer i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 0);
            }
        }
        Stream<Map.Entry<Integer, Integer>> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue());
        System.out.println(Arrays.toString(sorted.map(x -> x.getKey()).toArray()));
    }

    static void isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                System.out.println("FALSE");
                return;
            }
        }
        System.out.println("TRUE");
    }

    static void commonElementsOfArrays(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        for (int i: arr2) {
            set.add(i);
        }
        for (int i: arr1) {
            if (set.contains(i)) {
                System.out.print(i + " ");
            }
        }
    }

    static void longestSubstring(String s) {
        String[] words = s.split(" ");
        String longestWord = "";
        for (String word: words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println(longestWord);
    }


    static void permutationsOfString(String str) {
        permutationsOfString("", str);
    }

    static void permutationsOfString(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutationsOfString(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    static void removeRedundantParenthesis(String s) {
        List<String> list = new java.util.LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                for (int j = s.length() - 1; j >= i ; j--) {
                    if (s.charAt(j) == ')') {
                        String tmp = s.substring(i,j);
                        if (validEquation(tmp)) {
                            list.add(tmp);
                        }
                    }
                }
            }
        }
        System.out.println(String.valueOf(list));
    }

    static boolean validEquation(String s) {
        char[] arr = s.toCharArray();
        int lCount = 0;
        int rCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lCount++;
            }
            if (s.charAt(i) == ')') {
                rCount++;
            }
        }
        return lCount == rCount;
    }

    static void moveZeroesToEndOfArray(int[] arr) {
        int count = 0;
        for (int i = arr.length-1; i >= 0 ; i--) {
            if (arr[i] == 0) {
                int tmp = arr[i];
                arr[i] = arr[arr.length -1 - count];
                arr[arr.length -1 - count] = tmp;
                count++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static class Cards {
        class Card {
            Card(Integer value, String suit) {
                this.value = value;
                this.suit = suit;
            }
            Integer value;
            String suit;
        }

        List<Cards.Card> deck;

        public Cards() {
            deck = new LinkedList<>();
            for (int i = 1; i <= 14; i++) {
                deck.add(new Cards.Card(i, "Hearts"));
            }
            for (int i = 1; i <= 14; i++) {
                deck.add(new Cards.Card(i, "Diamonds"));
            }
            for (int i = 1; i <= 14; i++) {
                deck.add(new Cards.Card(i, "Spades"));
            }
            for (int i = 1; i <= 14; i++) {
                deck.add(new Cards.Card(i, "Clubs"));
            }
            print();
        }

        void print() {
            deck.forEach(card -> {
                System.out.print(card.suit + "|" + card.value + " ");
            });
            System.out.print("\n");
        }

        public void shuffle() {
            Random rand = new Random();
            for (int i = 0; i < deck.size(); i++) {
                int newInt = rand.nextInt(deck.size());
                Cards.Card card = deck.get(i);
                deck.set(i, deck.get(newInt));
                deck.set(deck.get(newInt).value, card);
            }
            print();
        }
    }

    static void removeRepeatingString(String s, int recurrence) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), count + 1);
            } else {
                map.put(s.charAt(i), 0);
            }
        }
        map.entrySet().stream().filter(x -> x.getValue() < recurrence).forEach(x -> {
            System.out.print(x.getKey());
        });
    }

    public static void printDistinctIntArray(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int i: arr) {
            set.add(i);
        }
        System.out.println(Arrays.toString(set.toArray()));
    }


    static final String[] kids = new String[]{"Anthony","Mark","Jen","Oscar","Christine","Betsy"};

    static void countKidsInCircle(String[] kids, int m) {
        List<String> kidsList = new ArrayList<>(Arrays.asList(kids));

        int counter = 0;
        int kidInt = 0;

        while (counter <= m) {
            String kid = kidsList.get(kidInt);
            if (counter == m) {
                kidsList.remove(kid);
                counter = -1;
                if (kidInt == kidsList.size()) {
                    kidInt = -1;
                }
            }
            if (kidInt == kidsList.size()-1) {
                kidInt = -1;
            }
            if (kidsList.size() <= 1) {
                System.out.println(kidsList.get(0));
                return;
            }
            kidInt++;
            counter++;
        }
    }
}
