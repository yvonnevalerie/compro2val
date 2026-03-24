package Activity2;

public class Week2Activity1 {
    public static void main(String[] args) {

        int[] theaterRow = { 0, 0, 0, 0, 0, 0, 0, 0 };

        theaterRow[3] = 1;

        int availableSeat = 0;

        for (int i = 0; i < theaterRow.length; i++) {
            if (theaterRow[i] == 0) {
                System.out.println("Available");
                availableSeat++;
            } else {
                System.out.println("Unavailable");
            }
        }

        System.out.println("Total available seat: " + availableSeat);

        int[][] theater = new int[5][8];

        theater[2][5] = 1;
        theater[0][0] = 1;

        int bookedSeat = 0;

        for (int row = 0; row < theater.length; row++) {
            for (int col = 0; col < theater[row].length; col++) {
                System.out.print(theater[row][col] + " ");
                if (theater[row][col] == 1) {
                    bookedSeat++;
                }
            }
            System.out.println();
        }

        System.out.println("Total reserved seat: " + bookedSeat);
    }
}
