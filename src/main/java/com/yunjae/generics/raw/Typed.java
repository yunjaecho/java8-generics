package com.yunjae.generics.raw;

import java.util.ArrayList;
import java.util.List;

public class Typed {
    public static void main(String[] args) {
        //RawType
        List<String> strings = new ArrayList<>();
        strings.add("this");
        strings.add("is");
        strings.add("a");
        strings.add("RAW");
        strings.add("list");
        strings.add("of");
        strings.add("strings");

        for (String s: strings) {
            System.out.printf("%7s has %d characters\n", s, args.length);
        }
    }
}
