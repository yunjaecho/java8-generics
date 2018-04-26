package com.yunjae.generics.max;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;

@Data
@AllArgsConstructor
public class Employee implements Comparable<Employee> {

    public static final Employee DEFAULT_EMPLOYEE = new Employee(0, "No Name");

    private int id;

    private String name;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Employee emp) {
        return this.getId() - emp.getId();
    }
}
