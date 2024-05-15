package com.test.sunfa.神奇数;

import java.util.Scanner;

/*
 * 题目：给出一个区间[a, b]，计算区间内“神奇数”的个数。

神奇数的定义：存在不同位置的两个数位，组成一个两位数（且不含前导0），且这个两位数为质数。
例子：153，可以使用数字3和数字1组成13，13是质数，满足神奇数。同样153可以找到31和53也为质数，只要找到一个质数即满足神奇数。
————————————————
版权声明：本文为CSDN博主「心歌技术」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_23994787/article/details/77886808
 *
 * */
public class 神奇数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int count = 0;
            for (int i = a; i <= b; i++) {
//                通过字符转换
                String tmp = i + "";
                boolean flag = false;
//                任意取两位
                for (int j = 0; j < tmp.length() - 1; j++) {
                    for (int k = j + 1; k < tmp.length(); k++) {
                        int first = (tmp.charAt(j) - '0') * 10 + tmp.charAt(k) - '0';
//                        必须构成二位数
                        if (first > 10 && isPrime(first)) {
                            count++;
                            flag = true;
                        } else {
                            int second = (tmp.charAt(k) - '0') * 10 + tmp.charAt(j) - '0';
                            if (second > 10 && isPrime(second)) {
                                count++;
                                flag = true;
                            }
                        }
//                        符合条件直接跳出
                        if (flag) {
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}