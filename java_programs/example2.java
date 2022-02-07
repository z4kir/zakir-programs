public class example2 {
    public static int getIndexOf(String[] strings, String item) {
        for (int i = 0; i < strings.length; i++) {
            if (item.equals(strings[i])) return i;
        }
        return -1;
    }

    public static void main(String... args) {
        String a[] = {"1", "2", "3", "4"};
        String x = "*";
        int n = getIndexOf(a, x);
        System.out.println("index of given number is" + n);

    }

}
