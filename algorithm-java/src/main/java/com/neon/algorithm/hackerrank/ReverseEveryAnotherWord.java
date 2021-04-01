package com.neon.algorithm.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseEveryAnotherWord {
    public static void reverseWords() {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        int counter = 0;

        // TODO: validate input
        while (scanner.hasNext()) {
            String word = scanner.next();

            if (++counter % 2 == 0) {
                words.add(word);
                continue;
            }

            char[] chars = word.toCharArray();
            for (int index = 0; index < chars.length / 2; index++) {
                int rightBoundary = chars.length - index - 1;
                char temp = chars[index];
                chars[index] = chars[rightBoundary];
                chars[rightBoundary] = temp;
            }

            words.add(new String(chars));
        }

        System.out.println(String.join(" ", words).trim());
    }
}


