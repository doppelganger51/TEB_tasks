package Librus;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Journal {
    public List<Student> studentsList;

    public Journal() {
        studentsList = new ArrayList<>();
    }
    public List<Student> getStudentsList() {
        if (studentsList.isEmpty()) {
            System.out.println("Lista uczniów jest pusta.");
        }
        return studentsList;
    }

    public void addStudent(Student student) {
        // Sprawdzanie czy dane zawierają tylko litery i czy nie są puste
        if (!student.getFirstName().matches("[a-zA-Z]+") || !student.getSecondName().matches("[a-zA-Z]+")) {
            System.out.println("Imię i nazwisko ucznia powinno składać się tylko z liter.");
            return;
        }
        if (student.getFirstName().isBlank() || student.getSecondName().isBlank()) {
            System.out.println("Imię i nazwisko ucznia nie może być puste.");
            return;
        }

        // Zmiana na pierwszą literę dużą, a pozostałe na małe
        String firstName = student.getFirstName().substring(0, 1).toUpperCase() + student.getFirstName().substring(1).toLowerCase();
        String secondName = student.getSecondName().substring(0, 1).toUpperCase() + student.getSecondName().substring(1).toLowerCase();

        student.setFirstName(firstName);
        student.setSecondName(secondName);

        boolean foundDuplicate = false;
        for (Student s : studentsList) {
            if (s.getFirstName().equals(student.getFirstName()) && s.getSecondName().equals(student.getSecondName())) {
                foundDuplicate = true;
                System.out.println("Uczeń o takim samym imieniu i nazwisku już istnieje.");
                System.out.println("Czy chcesz dodać kolejnego ucznia o takim samym imieniu i nazwisku? (t/n)");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.nextLine().trim();
                if (choice.equalsIgnoreCase("t")) {
                    studentsList.add(student);
                    System.out.println("Uczeń został dodany do dziennika.");
                } else {
                    System.out.println("Uczeń nie został dodany do dziennika.");
                }
                break;
            }
        }
        if (!foundDuplicate) {
            studentsList.add(student);
            System.out.println("Uczeń został dodany do dziennika.");
        }
    }

    public void removeStudent(Student student) {
        if (studentsList.isEmpty()) {
            System.out.println("Lista uczniów jest pusta, nie można usunąć ucznia.");
            return;
        }

        System.out.println("Czy na pewno chcesz usunąć ucznia " + student.getFirstName() + " " + student.getSecondName() + "?");
        System.out.println("Wpisz 'tak', aby potwierdzić.");

        Scanner scanner = new Scanner(System.in);
        String confirmation = scanner.nextLine();

        if (confirmation.equals("tak")) {
            studentsList.remove(student);
            System.out.println("Uczeń " + student.getFirstName() + " " + student.getSecondName() + " został usunięty z listy uczniów.");
        } else {
            System.out.println("Operacja usunięcia ucznia " + student.getFirstName() + " " + student.getSecondName() + " została anulowana.");
        }
    }

    public double getAverageStudentMark(Student student) {
        double averageMark = student.getAverageAllSubjectsMark();
        if (Double.isNaN(averageMark)) {
            System.out.println("Uczeń " + student.getFirstName() + " " + student.getSecondName() + " nie ma żadnych ocen.");
            return 0.0;
        }
        return averageMark;
    }

    public double getStudentsClassAverageMark() {
        double sum = 0;
        int markCount = 0;
        boolean anyMarks = false;
        for (Student student : studentsList) {
            double avgMark = getAverageStudentMark(student);
            if (avgMark > 0) {
                anyMarks = true;
                sum += avgMark;
                markCount += student.countAllSubjectsMarks();
            }
        }
        if (anyMarks) {
            return sum / markCount;
        } else {
            System.out.println("Brak ocen w dzienniku.");
            return 0;
        }
    }

    public void displayStudentsList() {
        if (studentsList.isEmpty()) {
            System.out.println("Lista uczniów jest pusta.");
        } else {
            for (int i = 0; i < studentsList.size(); i++) {
                Student student = studentsList.get(i);
                System.out.println((i + 1) + ". " + student.getFirstName() + " " + student.getSecondName());
            }
        }
    }
}
