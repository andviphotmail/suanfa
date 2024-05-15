package com.test.sunfa.监视器;

import java.util.Scanner;

//    华为od统一考试B卷【需要打开多少监视器】JAVA 实现
//        某长方形停车场，每个车位上方都有对应监控器，当且仅当在当前车位或者前后左右四个方向任意一个车位范围停车时，监控器才需要打开:
//        给出某一时刻停车场的停车分布，请统计最少需要打开多少个监控器
//        输入描述
//        第一行输入m，n表示长宽，满足1 < m,n <= 20;
//        后面输入m行，每行有n个0或1的整数，整数间使用一个空格隔开，表示该行已停车情况，其中0表示空位，1表示已停:
//        输出描述
//        最少需要打开监控器的数量
//        示例1：
//
//        输入
//        3 3
//        0 0 0
//        0 1 0
//        0 0 0
//        输出
//        5
//        说明 中间1的位置上需要打开监视器，且其上下左右皆需要打开监视器，共5个。
public class Test {
    // 定义数组内数据左右上下的方向，向左x-1，向右x+1，向上y+1,向下y-1
    public static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                arr[x][y] = scanner.nextInt();
            }
        }
        System.out.println("print arr");

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
                if (arr[i][j] == 1) {
                    count++;
                    continue;
                }
                for (int a = 0; a < 4; a++) {
                    int newX = i + directions[a][0];
                    int newY = j + directions[a][1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && arr[newX][newY] == 1) {
                        count++;
                    }
                }
            }
        }
        System.out.println("个数->" + count);
    }
}

class Main2 {
    public static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        int result = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (matrix[x][y] == 1) {
                    result++;
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int new_x = x + directions[i][0];
                    int new_y = y + directions[i][1];

                    if (new_x >= 0 && new_x < m && new_y >= 0 && new_y < n && matrix[new_x][new_y] == 1) {
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
        return;
    }
}


