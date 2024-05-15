package com.test.sunfa.全排列;

//给定一个只包含大写英文字母的字符串S，要求你给出对S重新排列的所有不相同的排列数。
//
//        如：S为ABA，则不同的排列有ABA、AAB、BAA三种。
//
//        解答要求
//
//        时间限制：5000ms, 内存限制：100MB
//
//        输入描述
//        输入一个长度不超过10的字符串S，确保都是大写的。
//
//        输出描述
//        输出S重新排列的所有不相同的排列数（包含自己本身）。
//
//        示例 1：
//        输入
//        ABA
//        输出
//        3
//        示例 2：
//        输入
//        ABCDEFGHHA
//        输出
//        907200

//1：全排列问题，其实就是回溯算法 -> DFS 回溯，没啥好说的。网上一大堆资料，最关键的就是记住这种写法，很多地方都能用到。
//回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：
//        找到一个可能存在的正确的答案；
//        在尝试了所有可能的分步方法后宣告该问题没有答案

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        char[] charArray = inputStr.toCharArray();
        Arrays.sort(charArray);
//        System.out.println(charArray.toString());
        List<Character> path = new ArrayList<>(); // 记录一个字符列表
        boolean[] used = new boolean[charArray.length];
        List<List<Character>> result = new ArrayList<>();

        solution(charArray, 0, path, used, result);
        System.out.println("main" + result.size());
    }

    public static void solution(char[] charArray, int depth, List<Character> path, boolean[] used, List<List<Character>> result) {
        // depth为深度
        if (depth == charArray.length) {
            result.add(new ArrayList<Character>(path));
//            System.out.println("depth00-" + result);
            return;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && charArray[i] == charArray[i - 1] && !used[i - 1]) {
                continue;
            }
            System.out.println(charArray[i]);
            path.add(charArray[i]);
//            System.out.println("000" + path);
            used[i] = true;
//            System.out.println("depth-" + depth);
            solution(charArray, depth + 1, path, used, result);
//            System.out.println("111" + path);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
