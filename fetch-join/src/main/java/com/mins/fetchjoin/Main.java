package com.mins.fetchjoin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("총 몇 명의 학생이 있나요?");
        int number = sc.nextInt();
        Student[] students = new Student[number];
        for (int i = 1; i <= number; i++) {
            students[i] = new Student();
        }
        for (int i = 1; i <= number; i++) {
            students[i].toString();
        }
    }

}
