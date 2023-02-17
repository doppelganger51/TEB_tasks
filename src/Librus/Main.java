package Librus;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Journal journal = new Journal();
        Scanner scanner = new Scanner(System.in);

        boolean operation = true;

        while (operation) {
            System.out.println("\nCo chcesz zrobić?");
            System.out.println("1. Dodaj ucznia");
            System.out.println("2. Usuń ucznia");
            System.out.println("3. Wyświetl listę uczniów");
            System.out.println("4. Wyświetl oceny ucznia");
            System.out.println("5. Dodaj ocenę ucznia");
            System.out.println("6. Usuń ocenę ucznia");
            System.out.println("8. Oblicz średnią ucznia");
            System.out.println("9. Oblicz średnią klasy");
            System.out.println("10. Zakończ program");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Student student = createStudent(scanner);
                    journal.addStudent(student);
                    break;

                case 2:
                    System.out.println("Którego ucznia chcesz usunąć?");
                    journal.displayStudentsList();
                    int indexToRemove = scanner.nextInt() - 1;
                    Student toRemove = journal.studentsList.get(indexToRemove);
                    journal.removeStudent(toRemove);
                    break;

                case 3:
                    System.out.println("Lista uczniów:");
                    journal.displayStudentsList();
                    break;

                case 4:
                    System.out.println("Którego ucznia oceny chcesz wyświetlić?");
                    journal.displayStudentsList();
                    int markIndex = scanner.nextInt() - 1;
                    Student oceny = journal.studentsList.get(markIndex);
                    System.out.println("Oceny ucznia " + oceny.getFirstName() + " " + oceny.getSecondName() + ":");
                    oceny.displayMarks();
                    break;

                case 5:
                    System.out.println("Któremu uczniowi chcesz dodać ocenę?");
                    journal.displayStudentsList();
                    int indeksDodaj = scanner.nextInt() - 1;
                    Student dodaj = journal.studentsList.get(indeksDodaj);
                    System.out.println("Do którego przedmiotu chcesz dodać ocenę?");
                    String przedmiot = scanner.next();
                    System.out.println("Podaj ocenę:");
                    int ocena = scanner.nextInt();
                    dodaj.addMark(przedmiot, ocena);
                    System.out.println("Dodano ocenę do ucznia " + dodaj.getFirstName() + " " + dodaj.getSecondName() + ".");
                    break;

                case 6:
                    System.out.println("Któremu uczniowi chcesz usunąć ocenę?");
                    journal.displayStudentsList();
                    int indeksUsunOcene = scanner.nextInt() - 1;
                    Student usunOcene = journal.studentsList.get(indeksUsunOcene);
                    System.out.println("Z którego przedmiotu chcesz usunąć ocenę?");
                    String przedmiotUsun = scanner.next();
                    System.out.println("Jaką ocenę chcesz usunąć?");
                    int ocenaUsun = scanner.nextInt();
                    usunOcene.removeMark(przedmiotUsun, ocenaUsun);
                    System.out.println("Usunięto ocenę ucznia " + usunOcene.getFirstName() + " " + usunOcene.getSecondName() + ".");
                    break;

                case 7:
                    System.out.print("Podaj indeks ucznia: ");
                    journal.displayStudentsList();
                    int studentIndex = scanner.nextInt() - 1;
                    if (studentIndex < 0 || studentIndex >= journal.getStudentsList().size()) {
                        System.out.println("Nieprawidłowy indeks ucznia");
                        break;
                    }
                    Student student1 = journal.getStudentsList().get(studentIndex);
                    System.out.print("Podaj nazwę przedmiotu: ");
                    String subject = scanner.next();
                    double srednia = student1.getAverageSubjectMark(subject);
                    if (srednia == -1) {
                        System.out.println("Uczeń nie ma ocen z przedmiotu " + subject);
                    } else {
                        System.out.println("Średnia ocen z przedmiotu " + subject + " dla ucznia " +
                                student1.getFirstName() + " " + student1.getSecondName() + ": " + srednia);
                    }
                    break;

                case 8:
                    System.out.println("Którego ucznia średnią chcesz obliczyć?");
                    journal.displayStudentsList();
                    int indeksSrednia = scanner.nextInt() - 1;
                    Student averageMark = journal.studentsList.get(indeksSrednia);
                    System.out.println("Średnia ucznia " + averageMark.getFirstName() + " " + averageMark.getSecondName() + ":");
                    System.out.println(averageMark.getAverageAllSubjectsMark());
                    break;

                case 9:
                    System.out.println("Średnia ocen całej klasy: ");
                    System.out.println(journal.getStudentsClassAverageMark());
                    break;

                case 10:
                    operation = false;
                    System.out.println("Koniec programu.");
                    break;

                default:
                    System.out.println("Nieprawidłowy wybór, spróbuj jeszcze raz.");
                    break;
            }
        }

        scanner.close();
    }

    public static Student createStudent(Scanner scanner) {
        System.out.println("Podaj imię ucznia:");
        String firstName = scanner.next();
        System.out.println("Podaj nazwisko ucznia:");
        String secondName = scanner.next();

        return new Student(firstName, secondName);
    }
}
