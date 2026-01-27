import java.util.Scanner;

public class Week3Activity1 {

    public static void main(String[] args) {
        //Problem 1
        Scanner sc = new Scanner(System.in);
        double[][] matrix = new double[3][4];
        double[][] matrix2 = new double[4][4];
        System.out.println("Enter a 3-by-4 matrix row by row:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        for (int col = 0; col < 4; col++) {
            System.out.println("Sum of the elements at column " + col +
                    " is " + sumColumn(matrix, col));
        }
        //Problem 2
        System.out.println("\nEnter a 4-by-4 matrix row by row:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix2[i][j] = sc.nextDouble();
            }
        }
        System.out.println("Sum of the elements in the major diagonal is "
                + sumMajorDiagonal(matrix2));

    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][columnIndex];
        }
        return sum;
    }

    public static double sumMajorDiagonal(double[][] m) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }
        return sum;
    }

    
        }

}
