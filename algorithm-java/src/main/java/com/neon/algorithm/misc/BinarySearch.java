package com.neon.algorithm.misc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class BinarySearch {
    private static final Logger log = LogManager.getLogger(BinarySearch.class.getName());

    public static <T extends Comparable> int recursiveSearch(List<T> sortedList, T item) {
        if (sortedList == null || item == null)
            throw new UnsupportedOperationException("Search isn't allowed for passed null arguments");

        log.debug(String.format("List: %s", sortedList));
        return recursiveSearch(sortedList, item, 0, sortedList.size() - 1);
    }

    private static <T extends Comparable> int recursiveSearch(List<T> sortedList, T item, int startIndex, int endIndex) {
        if (sortedList.isEmpty()) return -1;

        var middleIndex = (endIndex - startIndex) / 2 + startIndex;
        var middleItem = sortedList.get(middleIndex);

        log.debug(String.format("Indexes: Middle %s Start %s End %s", middleIndex, startIndex, endIndex));

        if (item.compareTo(middleItem) == 0)
            return middleIndex;
        else if (startIndex == endIndex)
            return -1;
        else if (item.compareTo(middleItem) < 0) {
            startIndex = 0;
            endIndex = middleIndex - 1;
            if (endIndex < 0) endIndex = 0;
        } else if (item.compareTo(middleItem) > 0) {
            startIndex = middleIndex + 1;
            if (startIndex > endIndex) startIndex = endIndex;
        }

        return recursiveSearch(sortedList, item, startIndex, endIndex);
    }
}
