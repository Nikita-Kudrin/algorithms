package com.neon.algorithm.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class OddNumberOfOccurences {
    public static void find_elements_with_odd_number_of_occurrences() {
        // TODO: validate input
        Scanner scanner = new Scanner(System.in);
        Integer count = scanner.nextInt();

        // TODO: try / catch in case of parsing errors
        List<Integer> values = new ArrayList<>();

        for (int index = 1; index <= count; index++) {
            String rawValue = scanner.next();
            values.add(Integer.parseInt(rawValue));
        }

        HashMap<Integer, Integer> frequencies = new HashMap<>();

        for (Integer item : values) {
            if (frequencies.containsKey(item)) {
                frequencies.put(item, frequencies.get(item) + 1);
            } else {
                frequencies.put(item, 1);
            }
        }

        String result = frequencies.entrySet().stream()
                .filter((it) -> it.getValue() % 2 != 0)
                .map((it) -> it.getKey())
                .sorted()
                .map(it -> it.toString())
                .reduce("", (String subtotal, String element) -> subtotal + " " + element);

        System.out.println(result.trim());
    }
}
