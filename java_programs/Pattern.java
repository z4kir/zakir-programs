import java.util.Scanner;


class Pattern1 {
    public void starPattern1(int numberofrows) {
        int g = 1;
        while (numberofrows > 0) {
            for (int i = 0; i < numberofrows - 1; i++) {
                System.out.print(" ");
            }
            numberofrows--;
            for (int i = 0; i < g; i++) {
                System.out.print("*");
            }
            g += 2;
            System.out.println("");
        }

    }

    public void starPattern2(int numberofrows) {
        int g = 1;
        int g1 = 1;
        int g2 = 0;
        int g3 = 1;
        int g4 = 0;
        int n = numberofrows;
        int n1 = numberofrows;
        int n2 = numberofrows;
        int n3 = numberofrows;
        float m = 0.3f * n1;
        int rang = 31;
        int s = 10;
        int l = 0;


        if (n2 < 8) {
            for (int i = 0; i < n2; i++) {
                for (int j = 0; j < n + n - 1; j++) {
                    System.out.print("*");
                }

                for (int k = 0; k < n + n - 6; k++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < g1; j++) {
                    System.out.print("*");
                }

                for (int k = 0; k < rang; k++) {
                    System.out.print(" ");

                }


                for (int j = 0; j < 6; j++) {
                    System.out.print("*");

                }
                rang -= 4;

                g1 += 2;


                System.out.println("");
                n2--;

            }
        } else {
            for (int i = 0; i < n2 - 2; i++) {
                for (int j = 0; j < n + n - 1; j++) {
                    System.out.print("Z");
                }
                for (int k = 0; k < n + n - 6; k++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < g1; j++) {
                    System.out.print("A");
                }

                for (int k = 0; k < rang; k++) {
                    System.out.print(" ");


                }

                rang -= 4;


                for (int j = 0; j < 6; j++) {
                    System.out.print("k");

                }
                for (int j = 0; j < s; j++) {
                    System.out.print(" ");

                }
                s -= 1;

                for (int j = 0; j < g; j++) {
                    System.out.print("k");
                }

                for (int j = 0; j < 6; j++) {
                    System.out.print("k");
                }
                g1 += 4;
                System.out.println("");
                n2--;
            }

        }
        rang += 3;
        while (n1 > 0) {
            for (int i = 0; i < n1 - 1; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < g; i++) {
                System.out.print("Z");
            }

            for (int i = 0; i < n1 - 1; i++) {
                System.out.print("Z");
            }

            for (int i = 0; i < g2; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < n + n - 6; i++) {
                System.out.print(" ");

            }
            for (int i = 0; i < (g1 - 4) / 2; i++) {
                System.out.print("A");

            }

            if (n1 > m) {
                for (int i = 0; i < g3; i++) {
                    System.out.print(" ");
                }
            } else {
                for (int i = 0; i < g3; i++) {
                    System.out.print("A");
                }
            }

            for (int i = 0; i < 7; i++) {
                System.out.print("A");

            }
            for (int k = 0; k < rang; k++) {
                System.out.print(" ");

            }
            for (int j = 0; j < 6; j++) {
                System.out.print("K");

            }
            if (n1 > 3) {
                if (n1 < 7) {
                    for (int i = 0; i < s; i++) {
                        System.out.print(" ");
                    }

                    for (int i = 0; i < 1; i++) {
                        System.out.print("K");
                    }

                    for (int i = 0; i < l; i++) {
                        System.out.print("K");
                    }

                } else {
                    for (int i = 0; i < s; i++) {
                        System.out.print(" ");
                    }

                    for (int i = 0; i < 1; i++) {
                        System.out.print("K");
                    }

                    for (int i = 0; i < 6; i++) {
                        System.out.print("K");
                    }
                }

            } else {


                for (int i = 0; i < g4; i++) {
                    System.out.print(" ");

                }
                for (int i = 0; i < 7; i++) {
                    System.out.print("K");


                }

            }
            s -= 1;

            rang -= 1;
            g2 += 1;
            g += 1;
            g4 += 1;
            g3 += 1;
            n1--;
            l += 2;


            System.out.println("");


        }
        if (n3 < 8) {
            for (int i = 0; i < n3; i++) {
                for (int j = 0; j < n + n - 1; j++) {
                    System.out.print("*");
                }
                for (int j = 0; j < n + n - 6; j++) {
                    System.out.print(" ");

                }
                for (int j = 0; j < (g1 - 4) / 2; j++) {
                    System.out.print("*");

                }
                for (int j = 0; j < g3; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 7; j++) {
                    System.out.print("*");

                }
                System.out.println("");
                n3--;
                g3 += 1;

            }
        } else {
            int c = 0;
            for (int i = 0; i < n3 - 2; i++) {
                for (int j = 0; j < n + n - 1; j++) {
                    System.out.print("Z");
                }
                for (int j = 0; j < n + n - 6; j++) {
                    System.out.print(" ");

                }
                for (int j = 0; j < (g1 - 4) / 2; j++) {
                    System.out.print("A");


                }
                for (int j = 0; j < g3; j++) {
                    System.out.print(" ");

                }
                for (int j = 0; j < 7; j++) {
                    System.out.print("A");

                }
                for (int k = 0; k < rang; k++) {
                    System.out.print(" ");

                }
                for (int j = 0; j < 6; j++) {
                    System.out.print("K");

                }
                for (int j = 0; j < g4; j++) {
                    System.out.print(" ");

                }
                for (int j = 0; j < 7; j++) {
                    System.out.print("K");

                }

                System.out.println("");
                rang--;
                n3--;
                g3 += 1;
                g4 += 1;

            }

        }


    }

    public void starPattern3(int numberofrows) {
        int g = 1;
        while (numberofrows > 0) {
            for (int i = 0; i < g; i++) {
                System.out.print("*");
            }
            g++;
            numberofrows--;
            System.out.println("");

        }

    }

    public void alphaPattern1(int numberofrows) {
        int g = 1;
        int n = 65;


        while (numberofrows > 0) {
            for (int i = 0; i < numberofrows - 1; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < g; i++) {
                char a = (char) n;

                if (i == (g - 1) / 2) {
                    n = 65;
                    a = (char) n;
                    System.out.print(a);
                    n++;
                    continue;
                }
                if (i < (g - 1) / 2) {
                    System.out.print(a);
                    n--;
                    continue;
                }

                System.out.print(a);
                n++;

            }
            numberofrows--;
            g += 2;
            System.out.println("");
        }

    }


}


class Pattern {
    public static void main(String[] args) {


        Pattern1 pattern = new Pattern1();
        pattern.starPattern2(10);


    }
}