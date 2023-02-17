package Librus;
import java.util.*;

class Student {
    private String firstName;
    private String secondName;
    private Map<String, List<Double>> subjectsAndMarks;

    public Student(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        subjectsAndMarks = new HashMap<>();
    }
    public void setFirstName(String firstName) {
    }

    public void setSecondName(String secondName) {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void addMark(String subject, double mark) {
        if (!subjectsAndMarks.containsKey(subject)) {
            subjectsAndMarks.put(subject, new ArrayList<>());
        }
        subjectsAndMarks.get(subject).add(mark);
    }

    public void removeMark(String subject, int index) {
        if (subjectsAndMarks.containsKey(subject)) {
            subjectsAndMarks.get(subject).remove(index);
            if (subjectsAndMarks.get(subject).isEmpty()) {
                subjectsAndMarks.remove(subject);
            }
        }
    }

    public void displayMarks() {
        if (subjectsAndMarks.size() == 0) {
            System.out.println("Brak ocen.");
        } else {
            for (Map.Entry<String, List<Double>> entry : subjectsAndMarks.entrySet()) {
                String subject = entry.getKey();
                List<Double> marksList = entry.getValue();
                System.out.print(subject + ": ");
                if (marksList.isEmpty()) {
                    System.out.println("Brak ocen.");
                } else {
                    for (double ocena : marksList) {
                        System.out.print(ocena + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public int countAllSubjectsMarks() {
        int marksCount = 0;
        for (List<Double> marks : this.subjectsAndMarks.values()) {
            marksCount += marks.size();
        }
        return marksCount;
    }


    public double getAverageSubjectMark(String subject) {
        if (subjectsAndMarks.containsKey(subject)) {
            List<Double> marksList = subjectsAndMarks.get(subject);
            double sum = 0;
            for (double mark : marksList) {
                sum += mark;
            }
            return sum / marksList.size();
        } else {
            return 0;
        }
    }

    public double getAverageAllSubjectsMark() {
        double sum = 0;
        int marksCount = 0;
        for (List<Double> marksList : subjectsAndMarks.values()) {
            for (double ocena : marksList) {
                sum += ocena;
                marksCount++;
            }
        }
        if (marksCount > 0) {
            return sum / marksCount;
        } else {
            return 0;
        }
    }
}