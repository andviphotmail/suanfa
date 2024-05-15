package com.test.sunfa.字符串处理;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        ABC<c89%000<
        test1();
    }

    private static void test1() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int number = 0;
        int up = 0;
        int low = 0;
        int special = 0;
        StringBuilder realStr = new StringBuilder();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char oneChar = input.charAt(i);
//            System.out.println(oneChar);
            if (oneChar != '<') {
                if (Character.isDigit(oneChar)) {
                    number = 1;
                } else if (Character.isLowerCase(oneChar)) {
                    low = 1;
                } else if (Character.isUpperCase(oneChar)) {
                    up = 1;
                } else if (!Character.isDigit(oneChar) && Character.isUpperCase(oneChar) && Character.isLowerCase(oneChar) && oneChar != ' ') {
                    special = 1;
                }
                realStr.append(oneChar);
            } else {
                realStr = new StringBuilder(realStr.substring(0, realStr.length() - 1));
            }
        }
        System.out.println(realStr);
        boolean flag = number > 0 && low > 0 && up > 0 && special > 0 && realStr.length() >= 8;
        if (flag) {
            System.out.println(realStr + ",true");
        } else {
            System.out.println(realStr + ",false");
        }
    }
}
