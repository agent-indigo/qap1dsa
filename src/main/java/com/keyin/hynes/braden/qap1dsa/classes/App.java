package com.keyin.hynes.braden.qap1dsa.classes;
import java.util.ArrayList;
import java.util.Scanner;
public final class App {
    private ArrayList<Double> numbers;
    private Scanner scanner;
    private String input;
    private double number;
    private double sum;
    private double avg;
    private App() {
        this.numbers = new ArrayList<Double>();
        this.scanner = new Scanner(System.in);
        this.sum = 0;
    }
    public static void main(String[] args) {
        App app = new App();
        try {
            app.calcAvg();
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        } finally {
            if (app.scanner != null) app.scanner.close();
        }
    }
    private void calcAvg() {
        while (true) {
            System.out.println("\nEnter a number, or 'done':\n");
            this.input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            } else {
                try {
                    this.number = Double.parseDouble(input);
                    numbers.add(number);
                } catch (NumberFormatException numberFormatException) {
                    System.err.println("Invalid input.");
                }
            }
            if (numbers.isEmpty()) {
                System.err.println("No numbers entered. Exiting.");
                System.exit(0);
            } else {
                for (double number : numbers) {
                    sum += number;
                }
                this.avg = sum / numbers.size();
                System.out.printf("Average: %f", avg);
            }
        }
    }
}