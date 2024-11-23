package com.om1cael;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("City: ");
            String city = scanner.next();

            new Skycast(city);
        }
    }
}