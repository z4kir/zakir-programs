package matrix;

import java.util.Scanner;
import java.lang.Math;

public class Deter {


    public double determinant(int n, double p[][]) {
        int i, j, k;
        double ans = 0;
        if (n == 1) {
            ans = p[0][0];
            return ans;
        } else {
            if (n == 2) {
                ans = p[0][0] * p[1][1] - p[0][1] * p[1][0];
                return ans;
            } else {
                for (i = 0; i < n; i++) {
                    double temp[][] = new double[n - 1][n - 1];
                    for (j = 0; j < n; j++) {
                        for (k = 0; k < n; k++) {
                            if (k < i && j != 0) {
                                temp[j - 1][k] = p[j][k];
                            } else {
                                if (k > i && j != 0) {
                                    temp[j - 1][k - 1] = p[j][k];
                                }
                            }
                        }
                    }
                    ans += p[0][i] * Math.pow(-1, i) * determinant((n - 1), temp);
                }
                return ans;
            }
        }
    }


    // public static void main(String... args){
    //      int n,c,d;
    //      System.out.println("enter matrix order");
    //      Scanner s=new Scanner(System.in);
    //      n=s.nextInt();
    //      int p[][]=new int[n][n];
    //      System.out.println("enter matrix elements");
    //      for(c=0;c<n;c++){
    //      for(d=0;d<n;d++){
    //      p[c][d]=s.nextInt();
    //      }
    //      }
    //      //For getting the valve of recursive function like in this case "ans" you have to follow step 51 to 52//
    //           deter g= new deter();
    //                int ans =g.determinant(n,p);
    //      System.out.print("matrix determinant is:  " +ans);
    //      }
}


     

