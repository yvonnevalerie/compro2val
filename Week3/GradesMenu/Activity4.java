import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Activity4 {

    static String[] subjects = new String[50];
    static double[][] grades = new double[50][3];
    static int count = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("""
                [1] Add Grade for subject
                [2] Exit
            """);

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.print("\nEnter Subject: ");
                subjects[count] = sc.nextLine();

                System.out.print("Enter Prelim Grade: ");
                grades[count][0] = sc.nextDouble();

                System.out.print("Enter Midterm Grade: ");
                grades[count][1] = sc.nextDouble();

                System.out.print("Enter Finals Grade: ");
                grades[count][2] = sc.nextDouble();

                sc.nextLine(); // clear buffer
                count++;
                System.out.println();

            } else if (choice == 2) {
                System.out.println("Good bye baby!! Muwah!");
            } else {
                System.out.println("Invalid choice!\n");
            }

        } while (choice != 2);

        writeData();
        sc.close();
    }

    public static void writeData() throws IOException {

        StringBuilder sb = new StringBuilder();
        sb.append("Subject,Prelim,Midterm,Finals\n");

        for (int r = 0; r < count; r++) {
            sb.append(subjects[r]);
            for (int c = 0; c < grades[r].length; c++) {
                sb.append(",").append(grades[r][c]);
            }
            sb.append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("data.csv"));
        bw.write(sb.toString());
        bw.close();

        System.out.println(sb.toString());
    }
}
