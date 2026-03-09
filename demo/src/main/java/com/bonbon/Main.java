package com.bonbon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.bonbon.model.Person;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        String json = "";
        Scanner sc = new Scanner(new File("data/dog.json"));
            while(sc.hasNextLine()){
                json += sc.nextLine();
            }
            Gson gson = new Gson();
            Person person = gson.fromJson(json, Person.class);

            person.setFirstName("bonbon");

            System.out.println("Hello dog!");
            System.out.println(person.toString());
        
                

        System.out.println("Hello ate");
    }
}