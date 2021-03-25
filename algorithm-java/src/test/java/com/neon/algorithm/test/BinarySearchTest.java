package com.neon.algorithm.test;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
    public void nullSourceCollection() {
        assertThrows(UnsupportedOperationException.class,
                () -> BinarySearch.recursiveSearch(null, 0));
    }

    @Test
    public void nullSearchedArgument() {
        assertThrows(UnsupportedOperationException.class,
                () -> BinarySearch.recursiveSearch(new ArrayList<Integer>(), null));
    }

    List<SearchTestData<Integer>> testDataBasicBinarySearchLogic = Arrays.asList(
            new SearchTestData<Integer>(Arrays.asList(0), 0, 0),
            new SearchTestData<Integer>(Arrays.asList(0, 1), 0, 0),
            new SearchTestData<Integer>(Arrays.asList(0, 1, 2), 0, 0),
            new SearchTestData<Integer>(Arrays.asList(0, 1, 2, 3), 0, 0),

            new SearchTestData<Integer>(Arrays.asList(1), 0, -1),
            new SearchTestData<Integer>(Arrays.asList(), 0, -1),
            new SearchTestData<Integer>(Arrays.asList(1, 2), 0, -1),
            new SearchTestData<Integer>(Arrays.asList(1, 2, 3), 0, -1),
            new SearchTestData<Integer>(Arrays.asList(1, 2, 3, 4), 0, -1),

            new SearchTestData<Integer>(Arrays.asList(0, 1), 1, 1),
            new SearchTestData<Integer>(Arrays.asList(0, 1, 2), 1, 1),
            new SearchTestData<Integer>(Arrays.asList(0, 1, 2), 2, 2),
            new SearchTestData<Integer>(Arrays.asList(0, 1, 2, 3), 1, 1),
            new SearchTestData<Integer>(Arrays.asList(0, 1, 2, 3), 2, 2),
            new SearchTestData<Integer>(Arrays.asList(0, 1, 2, 3), 3, 3)
    );

    @TestFactory
    public Stream<DynamicTest> search_basicLogicDynamicTest() {
        return testDataBasicBinarySearchLogic.stream()
                .map(testDataItem -> DynamicTest.dynamicTest("basicLogicDynamicTest",
                        () -> {
                            var searchResult = BinarySearch.recursiveSearch(testDataItem.collection, testDataItem.searchedItem);
                            assertThat(testDataItem.expectedSearchResult)
                                    .describedAs("Source collection: " +
                                            String.join(", ", testDataItem.collection.stream()
                                                    .map(it -> it.toString()).collect(Collectors.toList())) +
                                            " Searched element: " + testDataItem.searchedItem)
                                    .isEqualTo(searchResult);
                        }));
    }
}
