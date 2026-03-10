package com.valeriyaaa;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Student s = new Student();
       s.displayStudentInfo();

       Scanner sc = new Scanner(new File("data/students.csv"));
       while(sc.hasNextLine()){
        System.out.println(sc.nextLine());
       }
    }
}