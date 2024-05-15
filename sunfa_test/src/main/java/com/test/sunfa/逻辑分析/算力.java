//        现有两组服务器A和B，每组有多个算力不同的CPU，其中 A[i] 是A组第i个CPU的运算能力，B[i]是 B组 第i个CPU的运算能力。一组服务器的总算力是各CPU的算力之和。
//        为了让两组服务器的算力相等，允许从每组各选出一个CPU进行一次交换。
//        求两组服务器中，用于交换的CPU的算力，并且要求从A组服务器中选出的CPU，算力尽可能小。
//
//
//        输入描述
//        第一行输入为L1和L2，以空格分隔，L1表示A组服务器中的CPU数量，L2表示B组服务器中的CPU数量.
//        第二行输入为A组服务器中各个CPU的算力值，以空格分隔。
//        第三行输入为B组服务器中各个CPU的算力值，以空格分隔。
//        1 ≤ L1 ≤10000
//        1 ≤L2 ≤ 10000
//        1 ≤A[i] ≤100000
//        1 ≤ B[i]  ≤100000
//
//        输出描述
//        对于每组测试数据，输出两个整数，以空格分隔，依次表示A组选出的CPU算力，B组选出的CPU算力。要求从A组选出的CPU的算力尽可能小。
//        备注：保证两组服务器的初始总算力不同，答案肯定存在
//
//
//        示例1：
//
//        输入：
//        2 2
//        1 1
//        2 2
//        输出
//
//        1 2
//        说明
//        从A组中选出算力为1的CPU，与B组中算力为2的进行交换，使两组服务器的算力都等于3.
//
//        示例2：
//
//        输入：
//
//        2 2
//        1 2
//        2 3
//        输出
//        1 2
//
//        示例3：
//
//        输入：
//        1 2
//        2
//        1 3
//        输出
//        2 3
//
//        示例4：
//
//        输入：
//        3 2
//        1 2 5
//        2 4
//
//        输出：
//        5 4
//<option name="delegatedBuild" value="false" />


package com.test.sunfa.逻辑分析;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 算力 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int aNum = in.nextInt();
        int bNum = in.nextInt();
        int[] aArray = new int[aNum];
        int[] bArray = new int[bNum];
        int aaa = 0;
        int bbb = 0;
        for (int i = 0; i < aNum; i++) {
            aArray[i] = in.nextInt();
            aaa += aArray[i];
        }
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int j = 0; j < bNum; j++) {
            bArray[j] = in.nextInt();
            bbb += bArray[j];
            hashMap.put(bArray[j], 0);
        }

        int temp = aaa-bbb;
        solve(aArray, bArray, hashMap, temp);
    }

    // 解题思路，
    public static void solve(int[] aa, int[] bb, HashMap<Integer, Integer> hashMap, int cha) {
        Arrays.sort(aa);
        for (int i = 0; i < aa.length; i++) {
            int temp1 = aa[i] - cha / 2;
            if (hashMap.containsKey(temp1)) {
                System.out.println(aa[i] + " " + temp1);
                break;
            }
        }
//        System.out.println(cha);
    }


}

