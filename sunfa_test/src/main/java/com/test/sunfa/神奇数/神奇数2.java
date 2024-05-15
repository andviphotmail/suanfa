package com.test.sunfa.神奇数;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 神奇数2 {
    public static void main(String[] args){
        List<Integer>list = new ArrayList<Integer>();
        for(int i=11;i<100;i++){
            boolean isPrime = true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) list.add(i);
        }
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int cnt = 0;
        for(int i=a;i<=b;i++){
            String s = String.valueOf(i);
            for(Integer e: list){
                System.out.println("list->"+e+"||current->"+i);
                String s1 = String.valueOf(e/10);
                System.out.println("s1->"+s1);
                String s2 = String.valueOf(e%10);
                System.out.println("s2->"+s2);
                if(!s1.equals(s2)){
                    if(s.indexOf(s1)!=-1&&s.indexOf(s2)!=-1){
                        cnt++;
                        break;
                    }
                }else{
                    int index = s.indexOf(s1);
                    if(index!=-1&&s.indexOf(s2, index+1)!=-1){
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}
