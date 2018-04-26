package com.yunjae.generics.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

public class SortingDemo {
    private List<String> sampleStrings = Arrays.asList("This", "is", "a", "list", "of", "strings");

    // Java 7 using Collections.sort
    public List<String> alphaSort() {
        Collections.sort(sampleStrings);
        return sampleStrings;
    }

    // Default sort from java 8
    public List<String> alphaSortUsingStreams() {
        return sampleStrings.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    // Java 7 - using Comparator with anonymous inner class
    public List<String> lengthReverseSortWithComprator() {
        Collections.sort(sampleStrings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        return sampleStrings;
    }

    // Using a lambda as a Comparator with a lambda from java 8
    public List<String> lengthSortWithLambda() {
        Collections.sort(sampleStrings, (s1, s2) -> s1.length() - s2.length());
        return sampleStrings;
    }

    public List<String> lengthSortUsingSorted() {
        return sampleStrings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
    }

    // Length sort with comparingInt
    public List<String> lengthSortUsingCompartator() {
        return sampleStrings.stream()
                .sorted(comparing(String::length))
                .collect(Collectors.toList());
    }

    // Sort by length then alpha using sorted
    public List<String> lengthSortThenAlphaSortUsingSorted() {
        return sampleStrings.stream()
                .sorted(
                        comparing(String::length)
                        .thenComparing(naturalOrder()))
                .collect(Collectors.toList());
    }

    // Sort by length then reverse alpha using sorted
    public List<String> lengthSortThenReverseAlphaUsingSorted() {
        return sampleStrings.stream()
                .sorted(comparing(String::length).thenComparing(reverseOrder()))
                .collect(Collectors.toList());

    }




    public static void main(String[] args) {
        SortingDemo sortingDemo = new SortingDemo();
        List<String> sampleStrings = sortingDemo.alphaSort();

        for (String str : sampleStrings) {
            System.out.println(str);
        }
    }


}
