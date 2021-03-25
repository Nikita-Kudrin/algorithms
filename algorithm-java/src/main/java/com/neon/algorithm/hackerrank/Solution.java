package com.neon.algorithm.hackerrank;

import jdk.jshell.spi.ExecutionControl;

import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws ExecutionControl.NotImplementedException {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random(0);

        int numberOfAttendances = Integer.parseInt(sc.nextLine());
        int[] attendances = new int[numberOfAttendances];
        for (int i = 0; i < numberOfAttendances; i++)
            attendances[i] = Integer.parseInt(sc.nextLine());

        CustomRegister register = new CustomRegister();
        register.addAttendance(attendances);

        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String[] splitParts = sc.nextLine().split(" ");
            int id = Integer.parseInt(splitParts[0]);
            char c = splitParts[1].charAt(0);
            register.changeAttendance(id, c);
        }

        int reduceNumber = Integer.parseInt(sc.nextLine());
        register.reduceRegister(reduceNumber);

        int id = Integer.parseInt(sc.nextLine());
        register.personalAttendance(id);

        System.out.println("The maximum attendance is: " + register.maxAttendance());
    }
}
