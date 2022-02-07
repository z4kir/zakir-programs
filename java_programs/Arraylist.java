import java.util.ArrayList;

public class Arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(10);
        ArrayList<String> b = new ArrayList<>(10);
        a.add(2);
        b.add("a");
        a.add(3);
        b.add("b");
        a.add(7);
        b.add("d");
        a.add(5);
        b.add("e");
        a.add(9);
        b.add("h");
        a.add(3, 10);
        b.add("i");

        for (int i = 0; i < a.size(); i++) {
            System.out.println(b.get(i) + " | " + a.get(i));

        }

    }

}
