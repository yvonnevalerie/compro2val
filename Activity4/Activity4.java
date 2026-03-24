import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Activity4 {

    static String[] subjects = new String[50];
    static double[][] grades = new double[50][3];
    static int count = 0;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("""
                    -----------------------------
                                MENU
                    -----------------------------
                            """);
            System.out.println("""
                        [1] Add Grade for subject
                        [2] Exit
                    """);

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.print("\nEnter Subject: ");
                subjects[count] = sc.nextLine();

                System.out.print("Enter Prelim Grade: ");
                grades[count][0] = sc.nextDouble();

                System.out.print("Enter Midterm Grade: ");
                grades[count][1] = sc.nextDouble();

                System.out.print("Enter Finals Grade: ");
                grades[count][2] = sc.nextDouble();

                sc.nextLine();
                count++;
                System.out.println();

            } else if (choice == 2) {
                System.out.println("Subject");
            } else if (choice == 3) {
                System.out.println("Good bye , darleng;3!!\n");
                break;
            } 

            

        } while (choice != 2);

        writeData();
        sc.close();
    }

    public static void writeData() {
        StringBuilder sb = new StringBuilder();

        sb.append("Subject,Prelim,Midterm,Finals\n");
        for (int r = 0; r < subjects.length; r++) {
            if (subjects[r] == null)
                break;

            sb.append(subjects[r]);
            for (int c = 0; c < grades[r].length; c++) {
                sb.append(",").append(grades[r][c]);
            }
            sb.append("\n");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data.csv"))) {
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(sb.toString());

    }
}
