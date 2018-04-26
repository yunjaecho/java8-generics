package com.yunjae.generics.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Golfer implements Comparable<Golfer> {

    private String first;

    private String last;

    private int score;

    @Override
    public int compareTo(Golfer golfer) {
        return this.score - golfer.score;
    }

    @Override
    public String toString() {
        return "first : " + first + ", last : " + last + " , " +  score;
    }
}
