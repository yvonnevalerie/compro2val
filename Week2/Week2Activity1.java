package Week2;

public class Week2Activity1 {
    public static void main(String[] args){
        int[] theaterRow = {0, 0, 0, 0, 0, 0, 0, 0};
        theaterRow[3] = 1;

        int availableSeat = 0;
        for(int i = 0; i < theaterRow.length; i++){
            if(theaterRow[i] == 0){
                System.out.println("Available");
                availableSeat++;
            } else 
                System.out.println("Unavailable");
        }
        System.out.println("The total available seat:" + availableSeat);

    }

}
