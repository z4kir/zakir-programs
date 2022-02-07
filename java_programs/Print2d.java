
package matrix;

import java.util.Scanner;

public class Print2d {
    public void printm(int n, double b[][]) {

        int i, j;

        System.out.println("your matrix is ");

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }

    }
}
// public static void main(String... args) {
//     int n, c, d;
//     System.out.println("enter matrix order");
//     Scanner s = new Scanner(System.in);
//     n = s.nextInt();
//     int p[][] = new int[n][n];
//     System.out.println("enter matrix elements");
//     for (c = 0; c < n; c++) {
//         for (d = 0; d < n; d++) {
//             p[c][d] = s.nextInt();

//         }
//     }
//     Print2d g=new Print2d();
//     g.printm(n,p);

// }
// }
