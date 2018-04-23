package com.yunjae.generics.raw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RawTypes {
    public static void main(String[] args) {
        //RawType
        List strings = new ArrayList();
        strings.add("this");
        strings.add("is");
        strings.add("a");
        strings.add("RAW");
        strings.add("list");
        strings.add("of");
        strings.add("strings");
        strings.add(LocalDate.now());   // error : java.time.LocalDate cannot be cast to java.lang.String

        for (Object o: strings) {
            String s = (String) o;
            System.out.printf("%7s has %d characters\n", s, args.length);
        }
    }
}
