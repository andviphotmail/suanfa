package com.test.sunfa.逻辑分析;

import java.util.Scanner;

public class 掌握的单词个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }
        String matchWords = scanner.next();
        System.out.println(matchWords);
        test(words, matchWords);

    }

    static int test(String[] words, String matchWords) {
        int ans = 0;
        int[] matchWord = charCount(matchWords);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int[] singleWord = charCount(word);
            int count = 0;
            for (int j = 0; j < 128; j++) {
                System.out.println(matchWord[j]);
                System.out.println(singleWord[j]);
                count += Math.max(matchWord[j] - singleWord[j], 0);
            }
            if (count <= matchWord['?']) {
                ans++;
            }

        }
        System.out.println("ans-" + ans);
        return ans;
    }

    public static int[] charCount(String s) {
        int[] chars = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
//            System.out.println("c:" + c);
//            System.out.println("chars[c]:" + chars[c]);
            chars[c] += 1;
        }
        return chars;
    }
}
