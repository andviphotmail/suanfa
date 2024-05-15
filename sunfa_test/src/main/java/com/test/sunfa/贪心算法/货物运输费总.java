//        老李是货运公司承运人，老李的货车额定载货重量为 wt。现有两种货物、货物 A 单件重量为 wa ，单件运费利为 pa，货物 B 单件重量为 wb，单件运费利润为 pb.老李每次发车时载货总重量刚好为货车额定的载货重量 wt，车上必须同时有货物 A 和货物 B，货物 A、B 不可切割。老李单车次满载运输可获得的最高利润是多少?
//
//
//        输入描述
//        第一列输入为货物 A的单件重量 wa，0 < wa< 10000
//
//        第二列输入为货物 B的单件重量 wb， 0 < wb < 10000
//
//        第三列输入为货车的额定载重 wt， 0 < wt < 100000
//
//        第四列输入为货物 A 的单件运费利 pa， 0 < pa < 1000
//
//        第五列输入为货物 B 的单件运费利润 pb， 0 < pb< 1000
//        输出描述
//        单次满载运输的最高利润
//
//
//        示例1：
//        输入
//        10 8 36 15 7
//        输出
//        44
//        示例2：
//        输入
//        1 1 2 1 1
//        输出
//        2


package com.test.sunfa.贪心算法;

import java.util.Scanner;

public class 货物运输费总 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strArray = scanner.nextLine().split(" ");
        int[] numbers = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            numbers[i] = Integer.parseInt(strArray[i]);
        }
        test(numbers);
    }

    static void test(int[] numbers) {
        int wa = numbers[0];
        int wb = numbers[1];
        int wt = numbers[2];
        int pa = numbers[3];
        int pb = numbers[4];

        int a = 1;
        int b = 1;
        int allPrice = 0;
        while (wa * a + wb * b <= wt) {
            int realB = 0;
            if ((wt - wa * a) % wb == 0) {
                realB = (wt - wa * a) / wb;
                int temp = a * pa + realB * pb;
                if (temp > allPrice) {
                    allPrice = temp;
                }
            }
            a++;
        }
        System.out.println("a->" + --a);
        System.out.println("b->" + (wt - wa * a) / wb);
        System.out.println(allPrice);
    }
}
