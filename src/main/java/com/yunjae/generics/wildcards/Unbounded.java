package com.yunjae.generics.wildcards;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * On List<?>, only allowed methods:
 *   - Methods from List that don't need the contained type
 *
 */
public class Unbounded {
    public static void main(String[] args) {
        List<?> stuff = Arrays.asList("Hello", LocalDate.now(), 3);
        System.out.println("stuff.size() : " + stuff.size());
        stuff.forEach((Object o) -> System.out.println(o));

        //stuff.add("aaa"); // not work
        stuff.containsAll(Arrays.asList("Whatever", "else"));
    }
}
