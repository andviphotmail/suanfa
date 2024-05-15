//        现有若干个会议，所有会议共享一个会议室，用数组表示各个会议的开始时间和结束时间，格式为:
//
//        [[会议1开始时间，会议1结束时间]，[会议2开始时间，会议2结束时间]]
//
//        请计算会议室占用时间段。
//
//
//        输入描述
//        [[会议1开始时间，会议1结束时间]，[会议2开始时间，会议2结束时间]]
//
//        备注:
//        会议室个数范围: [1,100]
//        会议室时间段: [1,24]
//        输出描述
//        输出格式预输入一致,具体请看用例
//        [[会议开始时间，会议结束时间]，[会议开始时间，会议结束时间]]
//
//        示例1
//        输入:
//        [[1,4], [2,5],[7,9], [14,18]]
//        输出
//        [[1,5], [7,9],[14,18]]
//        说明:
//        时间段[1,4]和[2,5]重叠，合并为[1,5]
//
//
//        示例2
//        输入:
//        [[1,4],[4,5]]
//        输出:
//        [[1,5]]


package com.test.sunfa.逻辑分析;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class 会议室占用时间段 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = "[[3,4],[1,2],[2,5],[7,14],[13,18]]";
//        String inputStr = "[[1,4],[2,5],[7,9],[14,18]]";
        String outStr = inputStr.replace("[", "").replace("]", "");
        String[] temp = outStr.split(",");
        System.out.println(temp);
        ArrayList<Pair> arrayList = new ArrayList();
        for (int i = 0; i < temp.length; i++) {
            String aaa = temp[i];
            String bbb = temp[++i];
            System.out.println(aaa);
            System.out.println(bbb);

            arrayList.add(new Pair(Integer.parseInt(aaa), Integer.parseInt(bbb)));
        }
        arrayList.sort(Comparator.comparingInt(pair -> pair.key));


        solve(arrayList);
    }

// 解题思路，是用临时变量存储第一个，第二个的交集，然后再与下一个比较。只有在前一个value值，小于一个key的时候，才添加到临时列表中
    public static void solve(ArrayList<Pair> arrayList) {
        ArrayList<Pair> tempList = new ArrayList<>();
        Pair pair = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            Pair pairNext = arrayList.get(i);
            if (pair.getValue() < pairNext.getKey()) {
                tempList.add(pair);
                pair = pairNext;
            } else {
                if (pair.getValue() < pairNext.getValue()) {
                    pair = new Pair(pair.key, pairNext.value);
                }
            }
            if (i == arrayList.size() - 1) {
                tempList.add(pair);
            }
        }
        System.out.println(tempList);
    }

    static class Pair {
        private Integer key;
        private Integer value;

        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }

}

