package com.neon.algorithm.hackerrank;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


public class CustomRegister implements Register {
    // <studentId, attendance>
    HashMap<Integer, Integer> register;

    public CustomRegister() {
        register = new HashMap<>();
    }

    @Override
    public void addAttendance(int[] studentIds) {

        for (int studentId : studentIds) {
            int attendance;

            if (register.containsKey(studentId)) {
                attendance = register.get(studentId);
                attendance++;
            } else {
                attendance = 1;
            }

            register.put(studentId, attendance);
        }
    }

    @Override
    public void changeAttendance(int studentId, char symbol) {

        switch (symbol) {
            case 'A':
                // TODO: similar code - may use func<> (for something to do with attendance variable)
                if (register.containsKey(studentId)) {
                    int attendance = register.get(studentId);
                    attendance--;
                    register.put(studentId, attendance);
                    System.out.println(String.format("The attendance of student with id: {0} has been reduced by one", studentId));
                }
                break;
            case 'P':
                // TODO: similar code - may use func<> (for something to do with attendance variable)
                if (register.containsKey(studentId)) {
                    int attendance = register.get(studentId);
                    attendance++;
                    register.put(studentId, attendance);
                    System.out.println(String.format("The attendance of student with id: {0} has been increased by one", studentId));
                }
                break;
            default:
                System.out.println(String.format("Incorrect symbol {0} passed", symbol));
                // TODO: throw new NotImplementedException("Incorrect symbol passed");
        }

    }

    @Override
    public void reduceRegister(int limit) {
        System.out.println("Removing students with less attendance");

        Map<Integer, Integer> tempRegister = register.entrySet().stream()
                .filter(item -> item.getValue() >= limit)
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
        register = new HashMap<>(tempRegister);
    }

    @Override
    public void personalAttendance(int studentId) {
        if (register.containsKey(studentId)) {
            int attendance = register.get(studentId);
            System.out.println(String.format("The attendance of student with id: {0} is: {1}", studentId, attendance));
        } else {
            System.out.println(String.format("The student with id: {0} has been removed due to low attendance", studentId));
        }
    }

    @Override
    public int maxAttendance() {
        Optional<Map.Entry<Integer, Integer>> maxValue = register.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        return maxValue.get().getValue();
    }
}
