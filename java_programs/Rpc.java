package games;


import java.util.*;
import java.lang.String;

public class Rpc {
    public static void main(String... args) {
        String c[] = {"rock", "paper", "scissor"};
        System.out.println("\nenter rock , paper or scissor");
        String a[] = new String[5];
        a[0] = "first(1)";
        a[1] = "second(2)";
        a[2] = "third(3)";
        a[3] = "fourth(4)";
        a[4] = "five(5)";
        int h = 0, v = 0, b = 0;
        Scanner r = new Scanner(System.in);
        a:
        for (int i = 0; i < 5; i++) {
            System.out.print("\n\nround " + a[i] + "\nplayer:");

            String p = r.nextLine();
            Random ran = new Random();
            int u = ran.nextInt(c.length);
            if ((u == 0) && (p.equals("paper"))) {
                System.out.println("computr:" + c[u]);
                System.out.println("you won");
                h++;

            } else {
                if ((u == 1) && (p.equals("scissor"))) {
                    System.out.println("computr:" + c[u]);
                    System.out.println("you won");
                    h++;
                } else {
                    if ((u == 2) && (p.equals("rock"))) {
                        System.out.println("computr:" + c[u]);
                        System.out.println("you won");
                        h++;
                    } else {
                        if ((u == 0) && (p.equals("scissor"))) {
                            System.out.println("computr:" + c[u]);
                            System.out.println("you lose");
                            v++;
                        } else {
                            if ((u == 1) && (p.equals("rock"))) {
                                System.out.println("computr:" + c[u]);
                                System.out.println("you lose");
                                v++;

                            } else {
                                if ((u == 2) && (p.equals("paper"))) {
                                    System.out.println("computr:" + c[u]);
                                    System.out.println("you lose");
                                    v++;
                                } else {
                                    if ((c[u].equals(p))) {
                                        System.out.println("computr:" + c[u]);
                                        System.out.println("tie");
                                        b++;

                                    } else {
                                        System.out.println("inappropriate input");
                                        i--;
                                        continue a;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        System.out.println("\nwon:" + h + "\nlose:" + v + "\ntie:" + b);
        if (h > v) {
            System.out.println("\nCongratulation you beat the computer");

        } else {
            System.out.println("\nBetter luck next time");
        }

    }
}
