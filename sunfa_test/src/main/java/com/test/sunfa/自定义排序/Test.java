package com.test.sunfa.自定义排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {

        // 解题思路：
        // 首先，相同分数的人，放到一个列表中，然后以分数为key，list为value 创建map
        // 把所有分数方法到一个列表中
        // 找出列表中分数差最小的两个分数
        // 通过两个分数的key，分别获取对应的两个存在人id的列表
        // 两个列表嵌套循环输出。

//        8
//        1 90
//        2 91
//        3 92
//        4 85
//        5 86
//        6 92
//        7 90
//        8 85


        test1();
        System.out.println("----------------------------");
        test22();
    }

    private static void test1() {
        List<Student> stuList = new ArrayList<>();
        Map<Integer, List<Integer>> scoreMap = new HashMap<>(); // 相同分数的人的id
        List<Integer> scoreList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int id = scanner.nextInt();
            int score = scanner.nextInt();
            Student student = new Student(id, score);
            stuList.add(student);
            List<Integer> temp = new ArrayList<>();
            temp.add(id);
            if (!scoreMap.containsKey(score)) {
                scoreMap.put(score, temp);
            } else {
                List<Integer> temp22 = scoreMap.get(score);
                temp22.add(id);
                scoreMap.put(score, temp22);
            }
            scoreList.add(score);
        }
//        Collections.sort(stuList);
//        System.out.println(stuList);
        System.out.println(scoreMap);
        System.out.println(scoreList);

        List<Pair<Integer, Integer>> tempPairList = findMin(scoreList);
        System.out.println(tempPairList);

        for (int i = 0; i < tempPairList.size(); i++) {
            Pair<Integer, Integer> tempPair = tempPairList.get(i);
            int left = tempPair.getKey();
            int right = tempPair.getValue();
            List<Integer> leftKys = scoreMap.get(left);
            List<Integer> rightKys = scoreMap.get(right);
            for (int j = 0; j < leftKys.size(); j++) {
                for (int k = 0; k < rightKys.size(); k++) {
                    if (leftKys.get(j) < rightKys.get(k)) {
                        System.out.println(leftKys.get(j) + "," + rightKys.get(k));
                    } else {
                        System.out.println(rightKys.get(k) + "," + leftKys.get(j));
                    }

                }
            }
        }
    }

    public static List<Pair<Integer, Integer>> findMin(List<Integer> listScore) {
        Collections.sort(listScore);
        int defaultMin = 300;
        List<Pair<Integer, Integer>> tempList = new ArrayList<>();
        Pair<Integer, Integer> tempPair = null;
        for (int i = 1; i < listScore.size(); i++) {
            int tempMin = listScore.get(i) - listScore.get(i - 1);
            if (tempMin <= defaultMin) {
                defaultMin = tempMin;
                tempPair = new Pair<>(listScore.get(i - 1), listScore.get(i));
                tempList.add(tempPair);
            }
        }
        return tempList;
    }

    //    public static class Student implements Comparable<Student> {
    public static class Student {
        int id;
        int score;

        public Student(int id, int score) {
            this.id = id;
            this.score = score;
        }

        // compareTo 自然排序法
//        @Override
//        public int compareTo(Student student) {
//            System.out.println(student.score);
//            System.out.println(this.score);
//            return this.score - student.score;
//        }
    }

    // 使用一个简单的Pair类来存储两个整数
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }


    public static void test22() {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        List<Employee> all_employee = new ArrayList<>();
        List<int[]> pairs = new ArrayList<>();
        //最大差就是300
        int min_val = 300;

        HashMap<Integer, List<Integer>> score_map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (score_map.containsKey(b)) {
                List<Integer> temp = score_map.get(b);
                temp.add(a);
                score_map.put(b, temp);
                ;
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(a);
                score_map.put(b, temp);
            }
            Employee employee = new Employee(a, b);
            all_employee.add(employee);
        }
        //按照分数
        Collections.sort(all_employee);

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return Integer.compare(a1[0], a2[0]);
            }
        };

        int i = 1;
        while (true) {
            if (i >= count) {
//                pairs.sort(Comparator.comparingInt(a -> a[0]));
//                pairs.sort(new Comparator<int[]>() {
//                    @Override
//                    public int compare(int[] a1, int[] a2) {
//                        return Integer.compare(a1[0], a2[0]);
//                    }
//                });

                String output_str = "";
                for (int j = 0; j < pairs.size(); j++) {
                    output_str += pairs.get(j)[0] + " " + pairs.get(j)[1] + '\n';
                }
                System.out.println(output_str.substring(0, output_str.length() - 1));
                break;
            } else {
                int temp = all_employee.get(i).score - all_employee.get(i - 1).score;
                if (min_val > temp) {
                    min_val = temp;
                    pairs = new ArrayList<>();
                    for (int j = 0; j < score_map.get(all_employee.get(i - 1).score).size(); j++) {
                        if (score_map.get(all_employee.get(i - 1).score).get(j) < all_employee.get(i).id) {
                            pairs.add(new int[]{score_map.get(all_employee.get(i - 1).score).get(j), all_employee.get(i).id});
                        }
                    }

                } else if (min_val == temp) {
                    for (int j = 0; j < score_map.get(all_employee.get(i - 1).score).size(); j++) {
                        if (score_map.get(all_employee.get(i - 1).score).get(j) < all_employee.get(i).id) {
                            pairs.add(new int[]{score_map.get(all_employee.get(i - 1).score).get(j), all_employee.get(i).id});
                        }
                    }
                } else {
                    min_val = min_val;
                }
            }
            i += 1;
        }
    }

    public static class Employee implements Comparable<Employee> {
        int id;
        int score;

        public Employee(int id, int score) {
            this.id = id;
            this.score = score;
        }

        //com.example.suanfa.自定义排序
        @Override
        public int compareTo(Employee o) {
            return -o.score + this.score;
        }
    }

}
