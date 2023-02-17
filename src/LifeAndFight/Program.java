package LifeAndFight;
import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // Utworzenie nowego obiektu klasy Człowiek
        Person gamer = new Person(100, 0, 10);

        // Wyświetlenie początkowych statystyk
        gamer.viewStatistics();

        // Pętla gry
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Co chcesz zrobić?");
            System.out.println("1. Wyjście");
            System.out.println("2. Walka");
            System.out.println("3. Wyświetl statystyki");
            System.out.println("4. Ulecz się");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Koniec gry!");
                    return;
                case 2:
                    int damage = randomDamage();
                    gamer.fight(damage);
                    if (gamer.getHealth() <= 0) {
                        System.out.println("Zginąłeś!");
                        return;
                    } else {
                        System.out.println("Pokonałeś przeciwnika i zdobyłeś " + gamer.getExp() + " punktów doświadczenia!");
                    }
                    break;
                case 3:
                    gamer.viewStatistics();
                    break;
                case 4:
                    gamer.treat();
                    break;
                default:
                    System.out.println("Nieprawidłowa opcja!");
                    break;
            }
        }
    }

    private static int randomDamage() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }
}
