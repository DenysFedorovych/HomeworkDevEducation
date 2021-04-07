package com.github.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI {

    private List<Student> students = new ArrayList<Student>();

    public void init(List<Student> students) {
        this.students = students;
    }

    public StreamAPI() {
    }

    public List<Student> facultyStudents(String faculty) {
        return students.stream()
                .filter(s -> s.getFaculty().equals(faculty))
                .collect(Collectors.toList());
    }

    public List<Student> afterYear(int year) {
        return students.stream()
                .filter(s -> s.getYearOfBirth() > year)
                .collect(Collectors.toList());
    }

    public Student afterYearOneStudent(int year) {
        return students.stream()
                .filter(s -> s.getYearOfBirth() > year)
                .findFirst().get();
    }

    public List<Student> group(String group) {
        return students.stream()
                .filter(s -> s.getGroup().equals(group))
                .collect(Collectors.toList());
    }

    public long studentsByFaculty(String faculty) {
        long result = students.stream()
                .filter(s -> s.getFaculty().equals(faculty))
                .count();
        return result;
    }

    public List<Student> goToAnotherGroup(String group1, String group2) {
        return students.stream()
                .filter(student -> student.getGroup().equals(group1))
                .map(student -> student.setGroup(group2))
                .collect(Collectors.toList());
    }

    public String toSpecialFormat() {
        if (students.size() == 0) {
            return "";
        }
        List<String> list = new LinkedList<>();
        students.forEach(student -> list.add(studentToFormat(student)));
        return list.stream()
                .reduce((s, s2) -> s + "\n" + s2)
                .get();
    }

    private String studentToFormat(Student student) {
        return String.format("%s, %s - %s, %s",
                student.getFirstName(),
                student.getLastName(),
                student.getFaculty(),
                student.getGroup());
    }

    public Map<String, List<Student>> groupingByFaculty() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getFaculty));
    }

    public Map<String, List<Student>> groupingByCourse() {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getCourse));
    }

    public boolean ifOneFaculty(String faculty) {
        if(students.size() == 0) return false;
        return students.stream()
                .allMatch(student -> student.getFaculty().equals(faculty));
    }

    public boolean ifOneGroup(String group) {
        if(students.size() == 0) return false;
        return students.stream()
                .allMatch(student -> student.getGroup().equals(group));
    }

    public boolean ifOneOnFaculty(String faculty) {
        if(students.size() == 0) return false;
        return students.stream()
                .anyMatch(student -> student.getFaculty().equals(faculty));
    }

    public boolean ifOneInGroup(String group) {
        if(students.size() == 0) return false;
        return students.stream()
                .anyMatch(student -> student.getGroup().equals(group));
    }

}
