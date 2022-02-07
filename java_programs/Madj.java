package matrix;


import java.util.Scanner;
import java.lang.Math;

import matrix.Deter;

public class Madj {

    public double[][] madj1(int n, double p[][]) {
        int i, j, k, l;
        double c, d, f, g, b;
        double a[][] = new double[n][n];
        if (n == 1) {

            return p;
        }

        if (n > 1) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {
                    double temp[][] = new double[n - 1][n - 1];
                    for (k = 0; k < n; k++) {
                        for (l = 0; l < n; l++) {
                            if (k != i && l != j && k > i && l > j) {
                                temp[k - 1][l - 1] = p[k][l];
                            }
                            if (k != i && l != j && k > i && l < j) {
                                temp[k - 1][l] = p[k][l];
                            }
                            if (k != i && l != j && k < i && l < j) {
                                temp[k][l] = p[k][l];
                            }
                            if (k != i && l != j && k < i && l > j) {
                                temp[k][l - 1] = p[k][l];
                            }
                        }

                        // }
                        Deter o = new Deter();

                        a[i][j] = Math.pow(-1, i + j) * o.determinant((n - 1), temp);
                    }
                }
                //    Math.pow(-1,i+j)


            }


        }
        return a;
    }


    // public double determinant(int n, double p[][]) {
    //     int  i, j, k;
    //     double ans=0;
    //     if (n == 1) {
    //         ans = p[0][0];
    //         return ans;
    //     } else {
    //         if (n == 2) {
    //             ans = p[0][0] * p[1][1] - p[0][1] * p[1][0];
    //             return ans;
    //         } else {
    //             for (i = 0; i < n; i++) {
    //                 double temp[][] = new double[n - 1][n - 1];
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

    // public static void main(String[] args) {
    //     int n, c, d;
    //     System.out.println("enter matrix order");
    //     Scanner s = new Scanner(System.in);
    //     n = s.nextInt();
    //     double p[][] = new double[n][n];
    //     System.out.println("enter matrix elements");
    //     for (c = 0; c < n; c++) {
    //         for (d = 0; d < n; d++) {
    //             p[c][d] = s.nextDouble();
    //         }
    //     }

    //     Madj a = new Madj();
    //     double z[][] = a.madj1(n, p);
    //     matrix.Print2d y = new matrix.Print2d();
    //     y.printm(n, z);
    // }

}
