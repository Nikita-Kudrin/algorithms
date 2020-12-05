package com.neon.algorithm.misc;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SearchTestData<T extends Comparable> {

    public SearchTestData(List<T> collection, T searchedItem, int expectedPosition) {
        this.collection = collection;
        this.searchedItem = searchedItem;
        this.expectedSearchResult = expectedPosition;
    }

    public List<T> collection;
    public T searchedItem;
    public int expectedSearchResult;
}

public class BinarySearchTest {
    @Test
    public void zeroLengthCollection() {
        assertThrows(UnsupportedOperationException.class,
                () -> BinarySearch.search(new ArrayList<Integer>(), 0));
    }

    @Test
    public void nullSourceCollection() {
        assertThrows(UnsupportedOperationException.class,
                () -> BinarySearch.search(null, 0));
    }

    @Test
    public void nullSearchedArgument() {
        assertThrows(UnsupportedOperationException.class,
                () -> BinarySearch.search(new ArrayList<Integer>(), null));
    }

    @TestFactory
    public Stream<DynamicTest> basicLogicDynamicTest() {
        assertThrows(UnsupportedOperationException.class,
                () -> BinarySearch.search(new ArrayList<Integer>(), 0));

        var inputData = Arrays.asList(
                new SearchTestData<Integer>(Arrays.asList(0), 0, 0),
                new SearchTestData<Integer>(Arrays.asList(0, 1), 0, 0),
                new SearchTestData<Integer>(Arrays.asList(0, 1, 2), 0, 0),
                new SearchTestData<Integer>(Arrays.asList(1), 0, -1)
        );

        return inputData.stream()
                .map(testDataItem -> DynamicTest.dynamicTest("basicLogicDynamicTest",
                        () -> {
                            var searchResult = BinarySearch.search(testDataItem.collection, testDataItem.searchedItem);
                            assertThat(searchResult).isEqualTo(testDataItem.expectedSearchResult);
                        }));
    }
}
