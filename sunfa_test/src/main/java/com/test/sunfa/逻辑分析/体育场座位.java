//        在一个大型体育场内举办了一场大型活动，由于疫情防控的需要，要求每位观众的必须间隔至少一个空位才允许落座。现在给出一排观众座位分布图，座位中存在已落座的观众，请计算出，在不移动现有观众座位的情况下，最多还能坐下多少名观众。
//
//        输入描述
//
//        一个数组，用来标识某一排座位中，每个座位是否已经坐人。0表示该座位没有坐人，1表示该座位已经坐人。
//
//        输出描述
//
//        整数，在不移动现有观众座位的情况下，最多还能坐下多少名观众。
//
//        示例1输入输出示例仅供调试，后台判题数据一般不包含示例
//
//        输入
//
//        10001
//
//        输出
//
//        1
//
//        示例2
//
//        输入输出示例仅供调试，后台判题数据一般不包含示例
//
//        输入
//
//        0101
//
//        输出
//
//        0
//
//        备注
//
//        1<=数组长度<=10000


package com.test.sunfa.逻辑分析;


import java.util.Scanner;

public class 体育场座位 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputStr = in.nextLine();
//

        String[] arrayStr = inputStr.split("");
        int[] nums = new int[arrayStr.length];
        for (int i = 0; i < arrayStr.length; i++) {
            nums[i] = Integer.parseInt(arrayStr[i]);
        }
        int n = nums.length;
//        // 新解法
        solve2(nums, n);

        solve(inputStr);
    }

    public static void solve2(int[] nums, int n) {
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] != 0) {
                continue;
            } else {
                if (j == 0 || nums[j] == 0) {
                    if (j == n - 1 || nums[j + 1] == 0) {
                        if ((j == 0) || (j >= 1 && nums[j - 1] == 0)) {
                            count += 1;
                            nums[j] = 1;
                            j += 1;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static void solve(String inputStr) {

        String temp = "0" + inputStr + "0";
        String[] nums = temp.split("");
        int n = nums.length;
        int count = 0;
        for (int j = 1; j < n - 1; j++) {
            if (nums[j - 1].equals("0") && nums[j].equals("0") && nums[j + 1].equals("0")) {
                count++;
                nums[j] = "1";
            }
        }
        System.out.println(count);
    }

}

