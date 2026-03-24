package Activity1;
import java.util.Scanner;
public class Array{
    public static void main(String[]args){
        
        int[] number = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };
        for (int i=0; i < number.length; i++)
        System.out.println(number[i]);

         Scanner sc = new Scanner(System.in);
         System.out.print("Enter a number:");
         int n = sc.nextInt();
         int index = -1;
         for (int i =  0; i < number.length; i++){
            if (number[i] == n) {
                index = i;
                break;
            }
        
         }
          System.out.println("Index:" + index);



    }
}