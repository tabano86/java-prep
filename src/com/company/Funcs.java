package com.company;

import java.util.*;
import java.util.stream.IntStream;

class Funcs {
    int firstDuplicate(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (!set.add(a[i])) {
                return a[i];
            }
        }
        return -1;
    }

    char firstNotRepeatingCharacter(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (s.indexOf(arr[i]) == s.lastIndexOf(arr[i])) {
                return arr[i];
            }
        }
        return '_';
    }

    int[][] rotateImage(int[][] a) {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][a.length - 1 - j] = a[j][i];
            }
        }
        return result;
    }

    boolean sudoku2(char[][] grid) {
        Set<Character> set = new HashSet<>();
        for (int game = 0; game < 9; game++) {
            for (int row = game; row + game < grid.length; row++) {
                for (int col = game; col + game < grid[0].length; col++) {
                    if (!set.add(grid[row][col]) && grid[row][col] != '.') {
                        return false;
                    }
                }
            }
            set.clear();
        }
        return true;
    }

    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode<Integer> helper = new ListNode<>(0);
        helper.next = l;
        ListNode<Integer> p = helper;

        while (p.next != null) {
            if (p.next.value == k) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return helper.next;
    }

    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }
        T value;
        ListNode<T> next;

    }

    void add(ListNode<Integer> l, Integer val) {
        ListNode<Integer> current = l;
        while (current.next != null){
            current = current.next;
        }
        current.next = new ListNode<>(val);
    }

    ListNode<Integer> reverseListNode(ListNode<Integer> l) {
        ListNode<Integer> prev = null;
        ListNode<Integer> current = l;
        ListNode<Integer> next;

        while(current.next != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        l = prev;
        return l;
    }

    boolean containsDuplicates(int[] a) {
        Set<Integer> set = new HashSet<>();
        for(Integer val: a) {
            if (!set.add(val)) {
                return false;
            }

        }
        return true;
    }

    boolean sumOfTwo(int[] a, int[] b, int v) {
        if (a.length == 0 || b.length == 0) {
            return false;
        }



        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < b.length; j++) {
                if (a[i] + b[j] == v) {
                    return true;
                }
            }
        }
        return false;
    }

    int sumInRange(int[] nums, int[][] queries) {
        int total = 0;
        double mod = Math.pow(10,9) + 7;
        for(int[] q: queries)
            for(int i=q[0]; i<=q[1]; i++)
                total+=nums[i];
        return (int) (((total%mod)+mod)%mod);
    }

    Integer factorial(Integer n) {
        if (n<=1) {
            return 1;
        }
        return factorial(n-1) * n;
    }

    Long fibonacci(Integer n) {
        if(n <= 0)
            return 0L;
        if(n == 1)
            return 1L;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    Integer power(Integer p, Integer q) {
        if(q == 0) return 1;
        Integer tmp = power(p, q/2);
        if(q%2 == 0) {
            return tmp*tmp;
        } else {
            if (q > 0) {
                return p*tmp*tmp;
            } else {
                return (tmp*tmp)/q;
            }
        }
    }

    void binaryStringToInteger(String s) {
        int n = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            n += Integer.parseInt(String.valueOf(c[i])) * Math.pow(2,c.length - 1 - i);
        }
        System.out.println(n);
    }

    void integerToBinaryString(Integer n) {
        String result = "";
        while (n > 0) {
            if (n % 2 == 0) {
                result += "0";
            } else {
                result += "1";
            }
            n = n/2;
        }
        System.out.println(result);
    }

    Integer[] bubbleSort(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j]>arr[j+1]) {
                    Integer tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    Integer[] countSort(Integer[] arr) {
        int N = arr.length;
        if (N == 0)
            return arr;
        /* find maximum and minimum values */
        int max = arr[0], min = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int range = max - min + 1;

        int[] count = new int[range];
        /* initialize the occurrence of each element in the count array */
        for (int i = 0; i < N; i++)
            count[arr[i] - min]++;
        /* calculate sum of indexes **/
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
        /* modify original array according to the sum count */
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
                arr[j++] = i + min;
        return arr;
    }

    static void allPalindromes(String s) {
        s = s.replaceAll(" ", "");
        for (int i = 1; i < s.length(); i++) {
            int left = 1;
            int right = 1;
            while (i-left >= 0 && i+right+1 <= s.length()) {
                String tmp = s.substring(i-left, i+right+1);
                if (isPalindrome(tmp) && tmp.length() > 1) {
                    System.out.print(tmp + " ");
                }
                left++;
                right++;
            }
        }
    }

    static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
}
