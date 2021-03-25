package com.neon.algorithm.hackerrank;

public interface Register {
    void addAttendance(int[] studentIds);

    void changeAttendance(int studentId, char symbol);

    void reduceRegister(int limit);

    void personalAttendance(int studentId);

    int maxAttendance();
}
