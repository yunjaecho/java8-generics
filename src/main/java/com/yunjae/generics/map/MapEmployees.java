package com.yunjae.generics.map;

import com.yunjae.generics.max.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class MapEmployees {
    public static List<Employee> createEmployees() {
        return Arrays.asList(
                new Employee(1, "Peter Gibbons"),
                new Employee(2, "Samir Nagheenajar"),
                new Employee(3, "Michanel Boton"),
                new Employee(4, "Milton Waddams")
        );
    }

    public static void main(String[] args) {
        List<Employee> employees = createEmployees();
        List<String> names = employees
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toList());


        int totalLength = employees
                .stream()
                .map(Employee::getName)
                .mapToInt(String::length)
                .sum();

        Map<Integer, Employee> employeeMap = employees.stream()
                .collect(toMap(Employee::getId, Function.identity()));

        employeeMap.forEach((id, map) -> System.out.println(id + ":" + map));

        System.out.println("Sorted by key");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));


        System.out.println("Sorted(Reverse) by key");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        System.out.println("Sorted(comparingByValue) by key");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getName)))
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

    }
}
