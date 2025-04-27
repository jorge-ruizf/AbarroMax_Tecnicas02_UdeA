/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class Employees {
    private ArrayList<String> employees;

    
    public Employees(ArrayList<String> employees) {
        this.employees = employees;
    }

    
    public Employees() {
        this.employees = new ArrayList<>();
    }

    // Método para registrar un empleado desde consola
    public void registerEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del empleado: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("El nombre no puede estar vacío.");
        } else if (employees.contains(name)) {
            System.out.println("Ese empleado ya está registrado.");
        } else {
            employees.add(name);
            System.out.println("Empleado '" + name + "' registrado exitosamente.");
        }
    }

    // Método para agregar un empleado directamente
    public void addEmployee(String name) {
        if (!employees.contains(name)) {
            this.employees.add(name);
            System.out.println("Empleado '" + name + "' agregado.");
        } else {
            System.out.println("El empleado '" + name + "' ya existe.");
        }
    }

    // Mostrar empleados registrados
    public void listEmployees() {
        System.out.println("=== Lista de Empleados ===");
        for (String emp : employees) {
            System.out.println("- " + emp);
        }
    }

    // Getter
    public ArrayList<String> getEmployees() {
        return employees;
    }
}
