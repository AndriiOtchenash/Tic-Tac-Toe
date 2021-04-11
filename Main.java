package Solution;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    enum Status {
        GAME, XWIN, OWIN
    }

    static Status curStatus = Status.GAME;


    public static void main(String[] args) {

        int xs = 0;
        int os = 0;
        char[][] table = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = ' ';
            }
        }
        printTable(table);
        int x = 0;
        int y = 0;
        boolean check;

        while (curStatus == Status.GAME) {
            do {
                check = true;
                System.out.print("Enter the coordinates: ");
                Scanner scanner1 = new Scanner(System.in);

                try {
                    x = scanner1.nextInt();
                    y = scanner1.nextInt();
                    if (x == 0 || y == 0 || x > 3 || y > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        check = false;
                    } else {
                        if (table[x - 1][y - 1] == 'X' || table[x - 1][y - 1] == 'O') {
                            System.out.println("This cell is occupied! Choose another one!");
                            check = false;
                        }
                    }
                } catch (InputMismatchException e) {
                    check = false;
                    System.out.println("You should enter numbers!");
                }
            } while (!check);

            if (xs > os) {
                table[x - 1][y - 1] = 'O';
                os++;
            } else {
                table[x - 1][y - 1] = 'X';
                xs++;
            }

            printTable(table);

            if ((table[0][0] + table[0][1] + table[0][2] == 264) ||
                    (table[1][0] + table[1][1] + table[1][2] == 264) ||
                    (table[2][0] + table[2][1] + table[2][2] == 264) ||
                    (table[0][0] + table[1][0] + table[2][0] == 264) ||
                    (table[0][1] + table[1][1] + table[2][1] == 264) ||
                    (table[0][2] + table[1][2] + table[2][2] == 264) ||
                    (table[0][0] + table[1][1] + table[2][2] == 264) ||
                    (table[2][0] + table[1][1] + table[0][2] == 264)) {

                curStatus = Status.XWIN;
            }
            if ((table[0][0] + table[0][1] + table[0][2] == 237) ||
                    (table[1][0] + table[1][1] + table[1][2] == 237) ||
                    (table[2][0] + table[2][1] + table[2][2] == 237) ||
                    (table[0][0] + table[1][0] + table[2][0] == 237) ||
                    (table[0][1] + table[1][1] + table[2][1] == 237) ||
                    (table[0][2] + table[1][2] + table[2][2] == 237) ||
                    (table[0][0] + table[1][1] + table[2][2] == 237) ||
                    (table[2][0] + table[1][1] + table[0][2] == 237)) {
                curStatus = Status.OWIN;
            }
/*            if (winX && winO){
                System.out.println("Impossible");
                System.exit(0);
            }*/

            if (curStatus == Status.XWIN) {
                System.out.println("X wins");
                System.exit(0);
            }
            if (curStatus == Status.OWIN) {
                System.out.println("O wins");
                System.exit(0);
            }

/*            if (!winX && !winO && os + xs < 9) {
                System.out.println("Game not finished");
                System.exit(0);
            }*/

            if (xs + os == 9) {
                System.out.println("Draw");
                System.exit(0);
            }


        }
    }

    private static void printTable(char[][] table) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }
}