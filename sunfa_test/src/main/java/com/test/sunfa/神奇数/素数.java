package com.test.sunfa.神奇数;

import java.util.Scanner;

public class 素数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        // 输入一个数判断是否是素数
//        while (scanner.hasNext()) {
//            // 开平方计算
////            testSqrt(scanner.nextInt());
//            int number = scanner.nextInt();
//            System.out.println("" + number + "是否是素数" + isPr(number));
//        }


//        List list = new ArrayList();
//        // 2-100以内的素数
//        while (scanner.hasNext()) {
//            int number = scanner.nextInt();
//            for (int i = 2; i <=number;i++){
//                if(isPr(i)){
//                    list.add(i);
//                    System.out.println(i);
//                }
//            }
//            System.out.println(list.size());
//        }

//        testChar();
        testQuyu();

    }

    public static void testQuyu(){
        int a = 13 / 5;
        int b = 13 % 5;
        int c = 5 / 13;
        int d = 5 % 13;

        int e = 13 / -5;
        int f = -13 / 5;
        int h = -13 % 5;
        int j = 13 % -5;

        System.out.println(a + "，" + b);
        System.out.println(c + "，" + d);

        System.out.println(e + "，" + f);
        System.out.println(h + "，" + j);
    }

    public static void testChar(){
        String temp = 1240890 + "";
        int aa = temp.charAt(3)-'0';
        int aa2 = (temp.charAt(3) - '0') * 10;
        System.out.println(aa2);
    }


    //
    public static boolean isPr(int n) {
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }


    // 开平方公式 Math.sqrt()
    public static void testSqrt(int n) {
        System.out.println((int) Math.sqrt(n));
    }
}
