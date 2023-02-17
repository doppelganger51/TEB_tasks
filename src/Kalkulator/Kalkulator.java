package Kalkulator;

import java.util.Scanner;

public class Kalkulator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String operacja;
        double liczba1, liczba2, wynik;

        while (true) {
            System.out.println("Wybierz działanie (+,-,*,/,%) lub 'x' aby wyjść: ");
            operacja = input.next();
            if (operacja.equals("x")) {
                System.out.println("Program zakończył działanie.");
                break;
            }

            System.out.println("Podaj pierwszą liczbę: ");
            liczba1 = input.nextDouble();
            System.out.println("Podaj drugą liczbę: ");
            liczba2 = input.nextDouble();

            switch (operacja) {
                case "+":
                    wynik = liczba1 + liczba2;
                    System.out.println("Wynik: " + wynik);
                    break;
                case "-":
                    wynik = liczba1 - liczba2;
                    System.out.println("Wynik: " + wynik);
                    break;
                case "*":
                    wynik = liczba1 * liczba2;
                    System.out.println("Wynik: " + wynik);
                    break;
                case "/":
                    if (liczba2 == 0) {
                        System.out.println("Nie można dzielić przez zero!");
                    } else {
                        wynik = liczba1 / liczba2;
                        System.out.println("Wynik: " + wynik);
                    }
                    break;
                case "%":
                    if (liczba2 == 0) {
                        System.out.println("Nie można dzielić przez zero!");
                    } else {
                        wynik = liczba1 % liczba2;
                        System.out.println("Wynik: " + wynik);
                    }
                    break;
                default:
                    System.out.println("Nieprawidłowa operacja!");
            }
        }
        input.close();
    }
}
