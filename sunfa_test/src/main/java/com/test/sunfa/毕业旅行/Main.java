package com.test.sunfa.毕业旅行;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cityCount = scanner.nextInt();
        int[][] arr = new int[cityCount][cityCount];
        for(int i=0;i<cityCount;i++){
            for(int j=0;j<cityCount;j++){
                arr[i][j] = scanner.nextInt();
            }
        }
    }
}
