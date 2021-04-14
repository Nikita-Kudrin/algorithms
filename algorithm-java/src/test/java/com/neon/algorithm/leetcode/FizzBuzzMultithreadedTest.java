package com.neon.algorithm.leetcode;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FizzBuzzMultithreadedTest {
    @Test
    public void exampleTest() throws InterruptedException {
        int number = 15;
        FizzBuzzMultithreaded instance = new FizzBuzzMultithreaded(number);

        ExecutorService pool = Executors.newCachedThreadPool();
        for (var index = 0; index < 100; index++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        instance.fizz(this);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        instance.buzz(this);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        instance.fizzbuzz(this);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        instance.number(null);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
