package matrix;

import java.util.Scanner;

import matrix.*;
// import matrix.*;

public class minverse {
    // public double determinant(int n, double p[][]) {
    //     int ans = 0, i, j, k;
    //     if (n == 1) {
    //         ans = p[0][0];
    //         return ans;
    //     } else {
    //         if (n == 2) {
    //             ans = p[0][0] * p[1][1] - p[0][1] * p[1][0];
    //             return ans;
    //         } else {
    //             for (i = 0; i < n; i++) {
    //                 int temp[][] = new int[n - 1][n - 1];
    //                 for (j = 0; j < n; j++) {
    //                     for (k = 0; k < n; k++) {
    //                         if (k < i && j != 0) {
    //                             temp[j - 1][k] = p[j][k];
    //                         } else {
    //                             if (k > i && j != 0) {
    //                                 temp[j - 1][k - 1] = p[j][k];
    //                             }
    //                         }
    //                     }
    //                 }
    //                 ans += p[0][i] * Math.pow(-1, i) * determinant((n - 1), temp);
    //             }
    //             return ans;
    //         }
    //     }
    // }

    public static void main(String... args) {
        int n, c, d, i, j;
        System.out.println("enter matrix order");
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        double p[][] = new double[n][n];
        double b[][] = new double[n][n];
        System.out.println("enter matrix elements");
        for (c = 0; c < n; c++) {
            for (d = 0; d < n; d++) {
                p[c][d] = s.nextInt();
            }
        }
        Madj k = new Madj();
        double o[][] = k.madj1(n, p);
        Mtranspose v = new Mtranspose();
        double f[][] = v.mtrans(n, o);

        // for (c = 0; c < n; c++) {
        //     for (d = 0; d < n; d++) {
        //         b[c][d] = p[d][c];
        //     }
        // }

// System.out.println("transpose Matrix is ");
// for(i=0;i<n;i++){
// for(j=0;j<n;j++){
// System.out.print(b[i][j]+" ");
// }System.out.println();
// }
        // For getting the valve of recursive function like in this case "ans" you have
        // to follow step 51 to 52//
        Deter g = new Deter();
        double ans = g.determinant(n, p);
        System.out.print("\n\nmatrix determinant is:  " + ans + "\n\n");
        if (ans != 0) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    b[i][j] = (1 / ans) * f[i][j];
                }
            }
            Print2d y = new Print2d();
            y.printm(n, b);
        } else {
            System.out.println("inverse of this matrix is not possible");
        }
    }
}