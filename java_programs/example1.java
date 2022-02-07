public class example1 {
    public int[] getIndexOf2(String strings[][], String item) {
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
        example1 h = new example1();
        String x = "*";
        //    int l[]=new int[3];
        int[] k = h.getIndexOf2(b, x);
        System.out.println(k.length);

        System.out.println("rows:" + k[0] + "\ncolunms:" + k[1]);

    }
}


