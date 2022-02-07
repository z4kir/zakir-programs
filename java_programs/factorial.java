import java.util.Scanner;

class factorial {
    public static void main(String args[]) {
        int i, fact = 1;
        int num;
        Scanner input = new Scanner(System.in);
        System.out.println("enter num which factorial you want: ");
        num = input.nextInt();
        for (i = 1; i <= num; i++) {
            fact = fact * i;
        }
        System.out.println("factorial of " + num + " is " + fact);
    }
}
