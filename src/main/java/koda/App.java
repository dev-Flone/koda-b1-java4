package koda;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class App {
    static Optional<Employee> findEmployee(List<Employee> employees, String employeeId) {
        return employees.stream().filter(employee -> employee.getEmployeeId().equals(employeeId)).findFirst();
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        try {
            // List
            employees.add(new Employee("KR001", "Budi", 750000L));
            employees.add(new Employee("KR002", "Andi", 500000L));
        } catch (IllegalArgumentException e) {
            System.out.println("Gagal memuat data:" + e.getMessage());
            return;
        }

        // employees.stream().filter(employee -> employee.getBalance() >= 200000)
        // .sorted(Comparator.comparingDouble(Employee::getBalance)).toList()
        // .forEach(employee -> System.out.println(employee.getOwner() + " - " +
        // employee.getBalance()));

        try {
            System.out.println("ACTIVE QUERY");
            System.out.println();

            Employee employee = findEmployee(employees, "KR001")
                    .orElseThrow(() -> new NoSuchElementException("Tidak ditemukan"));
            System.out.println(employee.getOwner() + " - " + "Rp. " + employee.getBalance());
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
        ;
        // Optional<Employee> result = findEmployee(employees, 750000);

        // result.ifPresent(employee -> System.out.println(
        // employee.getOwner() + " - " +
        // employee.getBalance()));

        // Map
        // Map<Integer, Employee> employees = new LinkedHashMap<>();

        // employees.put(1, new Employee("KR001", "Andi", 7000000));
        // employees.put(2, new Employee("KR002", "Budi", 5000000));
        // employees.put(3, new Employee("KR003", "Citra", 6000000));

        // for (Employee employee : employees.values()) {
        // System.out.println(employee.getAccount() + " - " + employee.getOwner() + " -
        // " + employee.getBalance());
        // }

        // Set
        // Set<Employee> employees = new HashSet<>();
        // employees.add(new Employee("KR001", "Andi", 7000000));
        // employees.add(new Employee("KR002", "Budi", 5000000));
        // employees.add(new Employee("KR003", "Citra", 6000000));

        // Queue
        // Queue<Employee> employees = new ArrayDeque<>();
        // employees.offer(new Employee("KR001", "Andi", 7000000));
        // employees.offer(new Employee("KR002", "Budi", 5000000));
        // employees.offer(new Employee("KR003", "Citra", 6000000));

        // Printing
        // for (Employee employee : employees) {
        // System.out.println(employee.getOwner() + " - " + employee.getBalance());
        // }

    }

}
