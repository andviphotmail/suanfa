package com.test.sunfa.字符串处理;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test2 {
    //    1,2<C>4B,0aaa,6<B>,99
    static String[] cells;
    static Map cellMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
//        ABC<c89%000<
        int temp = 'A';
        System.out.println(temp);
        test1();
    }

    private static void test1() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int number = 0;
        int up = 0;
        int low = 0;
        int special = 0;

        cells = input.split(",");

        for (int i = 0; i < cells.length; i++) {
            String item = cells[i];
            if (test22(item, i)) {
//                System.out.println(true);
            } else {
                System.out.println(-1);
            }
        }
        for (int i = 0; i < cells.length; i++) {
            String item = cells[i];
            System.out.print(item);
            if (i < cells.length - 1) {
                System.out.print(",");
            }
        }

//        for (int i = 0; i < cells.length; i++) {
//            if (!change(cells[i], i)) {
//                System.out.println(-1);
//                return;
//            }
//        }
//        for (int i = 0; i < cells.length; i++) {
//            System.out.print(cells[i]);
//            if (i != cells.length - 1) {
//                System.out.print(",");
//            }
//        }


    }

    private static boolean test22(String item, int index) {
        System.out.println("item=>" + item);
        int indexleft = item.indexOf('<');
        int indexright = item.indexOf('>');

        // 正常
        if (item.length() > 100) {
            return false;
        } else if (indexleft == -1 && indexright == -1) {
            return true;
        } else if (indexleft < indexright && indexright - indexleft == 2) {
            System.out.println(item.length());
            String temp1 = item.replace("<", "");
            String temp2 = item.replace(">", "");
            if (temp1.length() == item.length() - 1 && temp2.length() == item.length() - 1) {
                char indexChar = item.substring(indexleft + 1, indexright).charAt(0);
                System.out.println("==item char->" + indexChar);
                int position = indexChar - 'A';
                if (position > 26) {
                    return false;
                } else {
                    String nextStr = cells[position];
                    System.out.println("==item nextStr->" + nextStr + "-position-" + position);
                    if (!test22(nextStr, position)) {
                        return false;
                    }
                    String tempResult = "";
                    tempResult += item.substring(0, indexleft);
                    tempResult += nextStr;
                    tempResult += item.substring(indexright + 1, item.length());

                    cells[index] = tempResult;
                    System.out.println("=item real->" + tempResult);
                }

                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean change(String cur_str, int index) {
        int result1 = cur_str.indexOf("<");
        int result2 = cur_str.indexOf(">");

        if (result1 == -1 && result2 == -1) {
            return true;
        } else if (result1 == -1 || result2 == -1) {
            //异常
            return false;
        } else if (result1 > result2 || result2 - result1 != 2) {
            //异常
            return false;
        } else {
            char target_pos = cur_str.substring(result1 + 1, result2).charAt(0);
            char cur_pos = (char) (index + 'A');
            if (!(target_pos >= 'A' && target_pos <= 'Z')) {
                //异常
                return false;
            }
            if (cur_pos == target_pos) {
                //异常
                return false;
            }
            int target_index = target_pos - 'A';
            if (!change(cells[target_index], target_index)) {
                return false;
            }
            String temp_result = "";
            temp_result += cur_str.substring(0, result1);
            temp_result += cells[target_index];
            temp_result += cur_str.substring(result2 + 1);
            cells[index] = temp_result;
        }
        return true;

    }

}
