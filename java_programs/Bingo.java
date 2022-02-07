package games;


import java.util.*;
// import java.lang.*;
import matrix.*;

public class Bingo {
    public int[] getIndexOf(String strings[][], String item) {
        int i, j;
        int q = 0;
        int b[] = new int[2];

        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                if (item.equals(strings[i][j])) {
                    b[0] = i;
                    b[1] = j;
                    return b;

                }
            }
        }

        b[0] = -1;
        b[1] = -1;
        return b;
    }

    public static void main(String... args) {
        int i, j;
        int c = 1;
        String p;
        String b[][] = new String[5][5];
        for (i = 0; i < 5; i++) {

            for (j = 0; j < 5; j++) {

                p = String.valueOf(c);
                b[i][j] = p;
                if (c < 11) {
                    System.out.print(b[i][j] + "      ");
                } else {
                    System.out.print(b[i][j] + "     ");
                }

                c++;
            }
            System.out.println();

        }
        System.out.println("enter total no. of player");
        Scanner z = new Scanner(System.in);
        int n = z.nextInt();
        String a[] = new String[n];
        String a1[] = new String[n];
        String a2[] = new String[n];
        String a3[] = new String[n];
        String a4[] = new String[n];
        int m = 1;
        int nz = 1;
        Scanner z1 = new Scanner(System.in);

        s:
        for (i = 0; i < n; i++) {
            System.out.println("enter player " + nz + " name:");
            a1[i] = z1.nextLine();
            for (j = 0; j < i; j++) {
                if (a1[i].equals(a1[j])) {
                    System.out.println("this name is already  taken please enter different name ");
                    i--;
                    continue s;


                }
            }

            System.out.println("enter player " + m + " digit ");
            int j1 = 1;
            x:
            while (j1 <= 25) {
                a[i] = z1.nextLine();
                for (j = 1; j <= 25; j++) {
                    String j2 = String.valueOf(j);
                    if (j2.equals(a[i])) {
                        break x;
                    }
                }
                System.out.println("Choosen number should be between 1 to 25 including 1 & 25");
                j1++;
            }

            System.out.println("\n\n\n\n\n\n\n\n\n\n");
            nz++;
            m++;
        }
        // for(i=0;i<n;i++){
        //     System.out.println("player digits are "+a[i] );
        // }
        m = 1;
        Scanner g = new Scanner(System.in);
        int s1 = 0;
        int k2 = 1;
        int k3[] = new int[n];
        int c1 = 0;
        int c3 = 0;
        int i1 = 0;
        int i3 = 1;
        int flag = 0;
        int c2 = 0;
        int u, y;
        int n3;
        int u1 = 1;

        outerloop:
        while (s1 < 25) {
            //   below if condition for putting loser value on the  last index of a2 array if there is only one loser.
            if (c1 == (n - 1)) {
                // System.out.println( "1..\n"+a2[n-1] );

                for (y = 0; y < n; y++) {
                    for (u = 0; u < n; u++) {
                        if (a1[y].equals(a2[u])) {
                            // System.out.println( "2..\n"+a1[y] + "  " +a2[n-1] );
                            flag++;
                            break;
                        }
                    }
                    if (flag == 0) {
                        a2[n - 1] = a1[y];
                        // System.out.println( "3..\n"+a1[y] + "  " +a2[n-1] );
                        break;

                    }
                    flag = 0;
                }
                break outerloop;

            }
            if (s1 == 24) {
                // System.out.println( "checking" );
                n3 = n - i1;
                if (n3 > 1) {
                    // System.out.println( "checking 0.5");

                    for (y = 0; y < n; y++) {
                        for (u = 0; u < n; u++) {
                            if (a1[y].equals(a2[u])) {
                                // System.out.println( "cecking 1");
                                flag++;
                                break;
                            }
                        }
                        if (flag == 0) {


                            a2[n - u1] = a1[y];
                            // System.out.println( "checking 2" );
                            u1++;
                        }

                        flag = 0;
                    }


                    break outerloop;

                }


            }
            // below loop represent the skipping of the winner players when ever outerloop i.e while(s2<25) repeat. 
            for (i = 0; i < n; i++) {
                if (k3[i] == k2) {
                    k2++;
                    if (k2 > n) {
                        k2 = 1;

                    }
                    continue outerloop;

                }
            }


            System.out.println("player " + k2 + " enter no. ");
            String x = g.nextLine();

            for (j = 1; j <= 25; j++) {
                String j2 = String.valueOf(j);
                if (j2.equals(x)) {
                    break;
                } else {
                    if (j >= 25) {
                        System.out.println("please enter number between 1 to 25 including 1 and 25");
                        continue outerloop;
                    }
                }
            }

            int x1 = Integer.valueOf(x);
            // System.out.println(x+"   "+x1);


            //    String x=Integer.toString(x1);


            //    below if condition is for player don't cut there choosen number.
            if (a[k2 - 1].equals(x)) {

                System.out.println("don't cut your choosen number");
                continue outerloop;

            }


            // below if condition is for player don't write number which is greater than 25.
            // if(x1>25){
            //     System.out.println("value is greater than 25 please insert again");
            //     continue outerloop;
            // } 

            // String x1=" ";
            Bingo h = new Bingo();
            int l[] = h.getIndexOf(b, x);


            //    System.out.println("position of enterd string \nrow:"+l[0]+"\ncolunm:"+l[1]);
            int n1 = l[0];
            int n2 = l[1];
            //    below condition for number which is already cut once.
            if (n1 == -1 && n2 == -1) {
                System.out.println("already inserted value , please insert again ");
                continue outerloop;
            }


            //  below contion for printing clean and uniform pattern.

            if (x1 < 11) {

                b[n1][n2] = "*";
            } else {
                b[n1][n2] = "* ";

            }


            int k, k1;
            // below condition for printing modified values of b[5][5].
            for (i = 0; i < 5; i++) {
                for (j = 0; j < 5; j++) {
                    if (i < 2) {
                        System.out.print(b[i][j] + "      ");

                    } else {
                        System.out.print(b[i][j] + "     ");
                    }
                }
                System.out.println();
            }

            int s2 = 0;
            c2 = 0;
            //    int y,u;
            //    int flag=0;
            // below condition storing winners values for printing linewise and for skipping.
            b:
            while (s2 < n) {
                if (a[s2].equals(x)) {
                    for (k = 1; k <= n; k++) {
                        if (a[k - 1].equals(x)) {

                            System.out.println(a1[k - 1] + " lose");
                            c1++;
                            a2[i1] = a1[k - 1];
                            a4[i1] = a[k - 1];
                            k3[i1] = k;
                            i1++;
                            c2++;


                        }
                    }

                    if (c2 > 1) {
                        c3 = c2;
                    }

                    break b;
                }


                s2++;
            }
            //   below if condition for putting winners value on the  last index of a2 array if there is more than one winners.
            // System.out.println( "checking values  "+s1);


            // following codition used for reset the player no after last player enter the value.
            k2++;
            if (k2 > n) {
                k2 = 1;

            }


            s1++;
            // System.out.println("checking...s1 values.... "+s1);
        }
        n3 = n - i1;
        i1 = n - 1;
        int i2 = 1;


        // System.out.println("checkin.....1.");


        // following while loop is for printing.
        System.out.println("\nrank list\n");

        c:
        while (i1 >= 0) {

            //    following if condition for printing winners if more than one winners.
            if (i1 == (n - 1)) {
                if ((n3 == 1)) {
                    System.out.println("\n winner\n" + i2 + ":" + a2[i1]);
                    i1--;
                    i2++;
                    continue c;

                } else {
                    System.out.println("\n winners");
                    for (i = n; i > n - n3; i--) {
                        System.out.println(i2 + ":" + a2[i - 1]);
                        i1--;
                    }
                    i2++;
                }
            } else {
                System.out.println("\n losers");
                for (i = n - n3 - 1; i >= 0; i--) {
                    System.out.println(i2 + ":" + a2[i]);
                    i1--;
                    for (j = i - 1; j >= 0; j--) {
                        if (a4[i].equals(a4[j])) {
                            System.out.println(i2 + ":" + a2[j]);

                            i--;
                            i1--;
                        }
                    }
                    i2++;
                }
                //    break c;
            }

            //    following if condition for printing winner if only one winner.
            //    if(i1==(n-1)&&(n3==1)){
            //     System.out.println(  "\n winner\n"+i2+":"+a2[i1]);
            //     i1--;
            //     i2++; 
            //    }

            //    //    following if condition for printing losers . 
            //    else{if (i1!=n) {
            //     System.out.println ("\n losers1");
            //        for(i=n-n3-1;i>=0;i--){
            //     System.out.println(i2+":"+a2[i]);
            //     i1--;
            //     for (j=i-1;j>=0;j--) {
            //         if (a4[i].equals(a4[j])) {
            //             System.out.println(i2+":"+a2[j]);

            //             i--;
            //             i1--;
            //         }  
            //     } 
            //         i2++;
            //        }

            //    }
            // }
            //    if(i1!=n3&&i1==n){
            //     System.out.println(  "\n loser\n"+i2+":"+a2[i1]);
            //     i1--;
            //     i2++; 
            //    }

        }

        //    following if condition for printing winners if all the palyers selected same number.
        //    if(s1==24){
        //     System.out.println("\nall the players are the winner");
        //    }
        // }

    }
}

        
