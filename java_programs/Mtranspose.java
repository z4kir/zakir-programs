package matrix;

import java.util.Scanner;

// import matrix.Print2d;
public class Mtranspose {
    public double[][] mtrans(int n, double p[][]) {
        int i, j;
// Scanner sc=new Scanner(System.in);
// System.out.println("enter no. of rows ");
// n=sc.nextInt();
// System.out.println("enter no. of columns ");
// m=sc.nextInt();
        double b[][] = new double[n][n];
// System.out.println("enter elements of matrix ");
// for(i=0;i<n;i++){
// for(j=0;j<m;j++){
// a[i][j]=sc.nextInt();
// }
// }
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                b[i][j] = p[j][i];
            }
        }

// for(i=0;i<m;i++){
// for(j=0;j<n;j++){
// System.out.print(b[i][j]+" ");
// }System.out.println();
// }
        return b;
    }

}




