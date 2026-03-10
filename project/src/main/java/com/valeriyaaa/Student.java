package com.valeriyaaa;

public class Student {
    String fullName;
    int age;
    String course;

    public Student(String firstName, String middleName, String lastName, int age, String course) {
        this.fullName = fullName;
        this.age = age;
        this.course = course;
    }

        public void displayStudentInfo() {
        System.out.println("Name       : " + fullName);
        System.out.println("Age        : " + age);
        System.out.println("Course     : " + course);

    }

}
