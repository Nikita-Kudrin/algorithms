package com.neon.algorithm.misc;

import java.util.List;

public class BinarySearch {
    public static <T extends Comparable> int search(List<T> collection, T item) {
        if (collection == null || collection.isEmpty())
            throw new UnsupportedOperationException("Search isn't allowed for empty or null collection");

        var middleIndex = collection.size() / 2;
        var middleItem = collection.get(middleIndex);

        if (middleItem.compareTo(item) == 0) return middleIndex;
        else if (item.compareTo(middleItem) < 0)
            return search(collection.subList(0, middleIndex), item);
        else if (item.compareTo(middleItem) > 0)
            return search(collection.subList(middleIndex, collection.size() - 1), item);
            // item isn't found in collection
        else return -1;
    }
}
