package com.neon.algorithm.leetcode;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 1195. Fizz Buzz Multithreaded
 * https://leetcode.com/problems/fizz-buzz-multithreaded/
 */
public class FizzBuzzMultithreaded {
    public FizzBuzzMultithreaded(int n) {
        this.maxNumber = n;
    }

    private volatile int counter;
    private final int maxNumber;
    private final CopyOnWriteArrayList<String> output = new CopyOnWriteArrayList<String>();

    private final Semaphore semaphore = new Semaphore(1);

    private boolean isDivisibleByNumberThree(int number) {
        return number % 3 == 0;
    }

    private boolean isDivisibleByNumberFive(int number) {
        return number % 5 == 0;
    }

    private synchronized int getIncreasedCounter() {
        int counterIncreased = counter + 1;

        if (counter > maxNumber) return -1;
        if (counterIncreased > maxNumber) {
            System.out.println(String.join(", ", output));
            return -1;
        }

        return counterIncreased;
    }

    // printFizz.run() outputs "fizz". ~ 3
    public void fizz(Runnable printFizz) throws InterruptedException {
        semaphore.acquire();

        try {
            int counterIncreased = getIncreasedCounter();

            if (isDivisibleByNumberThree(counterIncreased) && !isDivisibleByNumberFive(counterIncreased)) {
                counter++;

                output.add("fizz");
            }
        } finally {
            semaphore.release();
        }
    }

    // printBuzz.run() outputs "buzz". ~ 5
    public void buzz(Runnable printBuzz) throws InterruptedException {
        semaphore.acquire();

        try {
            int counterIncreased = getIncreasedCounter();

            if (isDivisibleByNumberFive(counterIncreased) && !isDivisibleByNumberThree(counterIncreased)) {
                counter++;
                output.add("buzz");
            }
        } finally {
            semaphore.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz". ~ 15
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        semaphore.acquire();

        try {
            int counterIncreased = getIncreasedCounter();

            if (isDivisibleByNumberThree(counterIncreased) && isDivisibleByNumberFive(counterIncreased)) {
                counter++;
                output.add("fizzbuzz");
            }
        } finally {
            semaphore.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer. (not fizz, buzz, fizzbuzz)
    public void number(IntConsumer printNumber) throws InterruptedException {
        semaphore.acquire();

        try {
            int counterIncreased = getIncreasedCounter();

            if (!(isDivisibleByNumberThree(counterIncreased) && isDivisibleByNumberFive(counterIncreased))) {
                counter++;
                output.add(Integer.toString(counter));
            }
        } finally {
            semaphore.release();
        }
    }
}
