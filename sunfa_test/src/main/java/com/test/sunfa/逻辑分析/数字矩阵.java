package com.test.sunfa.逻辑分析;

public class 数字矩阵 {
    // 定义数组内数据左右上下的方向，向左x-1，向右x+1，向上y+1,向下y-1
    public static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static int[] orientation = {0, 1, 0, -1, 0};


    public static void main(String[] args) {
//        test1(9, 4);
        test2(9, 4);
    }

    private static void test2(int number, int column) {
        int row = (int) Math.ceil(number * 1.0 / column);
        System.out.println(row);
        int[][] item = new int[row][column];
        int count = 1;
        int x = 0;
        int y = 0;
//        while (count < number) {
//            if (count == 1) {
//                item[0][0] = 1;
//                break;
//            }
//        }

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(i + " " + j + ",");
            }
            System.out.println();
        }
    }

    private static void test1(int number, int column) {
        int row = (int) Math.ceil(number * 1.0 / column);
        System.out.println(row);
        int[][] item = new int[row][column];
        int step = 1;
        int x = 0;
        int y = 0;
        int index = 0;

//                0 0,0 1,0 2,
//                1 0,1 1,1 2,
//                2 0,2 1,2 2,
//                3 0,3 1,3 2,

        while (true) {
            if (step > number) {
                break;
            } else {
                while (y < row && step <= number) {
                    item[x][y++] = step++;
                    System.out.println(item[x][y++]);
                }
                y = -1;
                x += 1;

                while (y < column && step <= number) {
                    item[x++][y] = step++;
                    System.out.println(item[x][y++]);
                }
                y -= 1;
                x -= 1;

                while (x < row && step <= number) {
                    item[x--][y] = step++;
                    System.out.println(item[x][y++]);
                }
                y += 1;
                x -= 1;

                while (y < column && step <= number) {
                    item[x][y--] = step++;
                    System.out.println(item[x][y--]);
                }
                x -= 1;
                y += 1;


//                System.out.println(index);
            }
        }
    }
}
