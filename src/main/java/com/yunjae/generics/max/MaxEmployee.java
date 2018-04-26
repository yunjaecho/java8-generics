package com.yunjae.generics.max;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MaxEmployee {

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

        Employee maxId = employees
                .stream()
                .max(Employee::compareTo)
                .orElse(Employee.DEFAULT_EMPLOYEE);

        Employee maxId2 = employees
                .stream()
                .max((a, b) -> a.getId() - b.getId())
                .orElse(Employee.DEFAULT_EMPLOYEE);

        Employee maxId3 = employees
                .stream()
                .max(new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return o1.getId() - o2.getId();
                    }
                })
                .orElse(Employee.DEFAULT_EMPLOYEE);

        Employee maxId4 = employees.stream()
                .max(Comparator.comparingInt(Employee::getId))
                .orElse(Employee.DEFAULT_EMPLOYEE);

        System.out.println("maxId : " + maxId);
        System.out.println("maxId2 : " + maxId2);
        System.out.println("maxId3 : " + maxId3);
        System.out.println("maxId4 : " + maxId4);

        Employee maxName = employees
                .stream()
                .max((a, b) -> a.toString().compareTo(b.toString()))
                .orElse(Employee.DEFAULT_EMPLOYEE);

        Employee maxName1 = employees.stream()
                .max(Comparator.comparing(Employee::getName))
                .orElse(Employee.DEFAULT_EMPLOYEE);


        System.out.println("maxName : " + maxName);
        System.out.println("maxName1 : " + maxName1);



    }

}
