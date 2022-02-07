import java.util.Scanner;
import java.lang.Math;

class expansion {
    public static void main(String... args) {
        double a, b, n, ans;
        System.out.println("enter the value of a");
        Scanner sc = new Scanner(System.in);
        a = sc.nextDouble();
        System.out.println("enter the value of b");
        Scanner ac = new Scanner(System.in);
        b = ac.nextDouble();
        System.out.println("enter the value of n");
        Scanner cs = new Scanner(System.in);
        n = cs.nextDouble();
        ans = Math.pow((a + b), n);
        System.out.println("expansion of (a+b)^n= " + ans);
    }
}
