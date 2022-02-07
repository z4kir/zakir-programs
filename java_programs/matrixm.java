import java.util.Scanner;

class matrixm {
    public static void main(String... args) {
        int i, j, k, m1, n1, m2, n2, sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter Matrix1 no. of rows ");
        n1 = sc.nextInt();
        System.out.println("enter Matrix1 no. of columns ");
        m1 = sc.nextInt();
        System.out.println("enter Matrix2 no. of rows ");
        n2 = sc.nextInt();
        System.out.println("enter Matrix2 no. of columns ");
        m2 = sc.nextInt();
        if (m1 == n2) {
            int a[][] = new int[n1][m1];
            int b[][] = new int[n2][m2];
            int c[][] = new int[n1][m2];
            System.out.println("enter elements of Matrix1");
            for (i = 0; i < n1; i++) {
                for (j = 0; j < m1; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            System.out.println("enter elements of Matrix2");
            for (i = 0; i < n2; i++) {
                for (j = 0; j < m2; j++) {
                    b[i][j] = sc.nextInt();
                }
            }
            for (i = 0; i < n1; i++) {
                for (j = 0; j < m2; j++) {
                    for (k = 0; k < m1; k++) {
                        sum = sum + a[i][k] * b[k][j];
                    }
                    c[i][j] = sum;
                    sum = 0;
                }
            }
            System.out.println("Matrix1 x Matrix2 is ");
            for (i = 0; i < n1; i++) {
                for (j = 0; j < m2; j++) {
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Matrix does not multiply ");
        }
    }
}
