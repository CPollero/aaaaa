package ui;

import model.Controller;
import model.Departamento;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lista original:");
        if (controller.getDepartamentos().isEmpty()) {
            System.out.println("No se cargaron datos. Verifique el archivo JSON.");
        } else {
            for (Departamento d : controller.getDepartamentos()) {
                System.out.println(d);
            }
        }

        int option;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ordenar por total de medallas");
            System.out.println("2. Ordenar por medallas de oro");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\nOrdenando por total de medallas...");
                    controller.sortByTotalMedals();
                    System.out.println("Departamentos ordenados por total de medallas:");
                    for (Departamento d : controller.getDepartamentos()) {
                        System.out.println(d);
                    }
                    break;
                case 2:
                    System.out.println("\nOrdenando por medallas de oro...");
                    controller.sortByGoldMedals();
                    System.out.println("Departamentos ordenados por medallas de oro:");
                    for (Departamento d : controller.getDepartamentos()) {
                        System.out.println(d);
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 3);

        scanner.close();
    }
}